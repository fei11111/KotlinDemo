package com.fei.kotlindemo.db

import android.content.ContentValues
import com.fei.kotlindemo.db.helper.ForecastDbHelper
import com.fei.kotlindemo.db.mapper.DbDataMapper
import com.fei.kotlindemo.db.model.CityForecast
import com.fei.kotlindemo.db.model.DayForecast
import com.fei.kotlindemo.db.table.CityForecastTable
import com.fei.kotlindemo.db.table.DayForecastTable
import com.fei.kotlindemo.domain.model.ForecastList
import com.fei.kotlindemo.extension.parseList
import com.fei.kotlindemo.extension.parseOpt
import org.jetbrains.anko.db.dropTable
import org.jetbrains.anko.db.select

/**
 *
 * @ClassName: ForecastDb
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/25 10:09
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/25 10:09
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class ForecastDb(
    private val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
    private val dbDataMapper: DbDataMapper
) {

    /**
     * 从数据库查数据
     */
    fun requestForecastByZipCode(zipCode: String, date: Long) = forecastDbHelper.use {
        val dailyForecast = select(DayForecastTable.NAME).whereSimple(
            "${DayForecastTable.CITY_ID} = ? AND ${DayForecastTable.DATE} >= ?",
            zipCode,
            date.toString()
        ).parseList {
            DayForecast(HashMap(it))
        }

        val city = select(CityForecastTable.NAME).whereSimple(
            "${CityForecastTable.ID} = ?", zipCode
        ).parseOpt { CityForecast(HashMap(it), dailyForecast) }

        if (city != null) dbDataMapper.convertToDomain(city) else null
    }

    /**
     * 插入数据库
     */
    fun insertToDb(forecastList: ForecastList) {
        val cityForecast: CityForecast = dbDataMapper.convertFromDomain(forecastList)
        forecastDbHelper.use {
            dropTable(CityForecastTable.NAME)
            dropTable(DayForecastTable.NAME)
            with(cityForecast) {
                val contentValues = ContentValues()

                contentValues.put(CityForecastTable.ID, _id)
                contentValues.put(CityForecastTable.CITY, city)
                contentValues.put(CityForecastTable.COUNTRY, country)
                insert(CityForecastTable.NAME, null, contentValues)

                dailyForecast.forEach { e ->
                    contentValues.clear()
                    contentValues.put(DayForecastTable.CITY_ID, _id)
                    contentValues.put(DayForecastTable.DATE, e.date)
                    contentValues.put(DayForecastTable.DESCRIPTION, e.description)
                    contentValues.put(DayForecastTable.HIGH, e.high)
                    contentValues.put(DayForecastTable.LOW, e.low)
                    contentValues.put(DayForecastTable.ICON_URL, e.iconUrl)
                    insert(DayForecastTable.NAME, null, contentValues)
                }

            }
        }
    }

}



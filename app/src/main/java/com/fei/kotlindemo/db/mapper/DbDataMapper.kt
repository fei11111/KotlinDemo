package com.fei.kotlindemo.db.mapper

import com.fei.kotlindemo.db.model.CityForecast
import com.fei.kotlindemo.db.model.DayForecast
import com.fei.kotlindemo.domain.model.Forecast
import com.fei.kotlindemo.domain.model.ForecastList

/**
 *
 * @ClassName: DbDataMapper
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/25 10:09
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/25 10:09
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class DbDataMapper {
    /**
     * 数据库数据转成model数据
     */
    fun convertToDomain(city: CityForecast): ForecastList =
        ForecastList(city._id, city.city, city.country, convertToForecast(city.dailyForecast))

    private fun convertToForecast(dailyForecast: List<DayForecast>): List<Forecast> =
        dailyForecast.map {
            with(it) {
                Forecast(
                    date = date,
                    description = description,
                    high = high,
                    low = low,
                    iconUrl = iconUrl
                )
            }
        }

    /**
     * model数据转成数据库数据
     */
    fun convertFromDomain(forecastList: ForecastList) =
        CityForecast(
            forecastList._id, forecastList.city, forecastList.country,
            convertDayForecastFromDomain(forecastList.dailyForecast, forecastList._id)
        )


    private fun convertDayForecastFromDomain(
        dailyForecast: List<Forecast>,
        cityId: Long
    ): List<DayForecast> = dailyForecast.map {
        with(it) {
            DayForecast(date, description, high, low, iconUrl, cityId)
        }
    }
}
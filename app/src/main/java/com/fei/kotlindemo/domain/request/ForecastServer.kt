package com.fei.kotlindemo.domain.request

import android.util.Log
import com.fei.kotlindemo.`interface`.ForecastDataSource
import com.fei.kotlindemo.db.ForecastDb
import com.fei.kotlindemo.domain.mapper.ForecastDataMapper
import com.fei.kotlindemo.domain.model.Forecast
import com.fei.kotlindemo.domain.model.ForecastList

/**
 *
 * @ClassName: ForecastServer
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/26 10:29
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/26 10:29
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

/**
 * 网络请求
 */
class ForecastServer(private val forecastDb: ForecastDb = ForecastDb()) : ForecastDataSource {
    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val forecastRequest = ForecastRequest(zipCode)
        val forecastList =
            ForecastDataMapper(zipCode).convertForecastToList(forecastRequest.execute())
        Log.i("Tag",forecastList.toString())
        forecastDb.insertToDb(forecastList)
        return forecastList
    }

    override fun requestDayForecast(id: Long): Forecast? {
        TODO("Not yet implemented")
    }
}
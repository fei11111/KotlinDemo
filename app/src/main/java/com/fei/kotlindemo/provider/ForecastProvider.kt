package com.fei.kotlindemo.provider

import com.fei.kotlindemo.`interface`.ForecastDataSource
import com.fei.kotlindemo.db.ForecastDb
import com.fei.kotlindemo.domain.model.ForecastList
import com.fei.kotlindemo.domain.request.ForecastServer
import com.fei.kotlindemo.extension.firstResult

/**
 *
 * @ClassName: ForecastProvider
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/26 10:30
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/26 10:30
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class ForecastProvider(private val source: List<ForecastDataSource> = ForecastProvider.SOURCE) {

    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCE = listOf<ForecastDataSource>(
            ForecastDb(), ForecastServer()
        )
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList? =
        source.firstResult {
            requestSource(it, zipCode, days)
        }

    private fun requestSource(it: ForecastDataSource, zipCode: Long, days: Int): ForecastList? {
        val res = it.requestForecastByZipCode(zipCode, todayTimeSpan())
        return if (res != null && res.size() >= days) res else null
    }


    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS

}
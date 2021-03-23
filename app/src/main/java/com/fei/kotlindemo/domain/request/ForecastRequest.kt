package com.fei.kotlindemo.domain.request

import com.fei.kotlindemo.domain.response.ForecastResult
import com.google.gson.Gson
import java.net.URL

/**
 *
 * @ClassName: Request
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/23 10:22
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/23 10:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class ForecastRequest(private val zipCode: String) {

    companion object {
        private const val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private const val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private const val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }

}
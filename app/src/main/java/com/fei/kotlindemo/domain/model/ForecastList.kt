package com.fei.kotlindemo.domain.model

/**
 *
 * @ClassName: ForecastList
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/23 10:56
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/23 10:56
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
data class ForecastList(
    val _id: Long,//zipcode
    val city: String, val country: String,
    val dailyForecast: List<Forecast>
) {

    operator fun get(position: Int) = dailyForecast[position]

    fun size() = dailyForecast.size
}


data class Forecast(
    val date: Long, val description: String, val high: Int,
    val low: Int, val iconUrl: String
)
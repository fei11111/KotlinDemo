package com.fei.kotlindemo.domain.mapper

import com.fei.kotlindemo.domain.model.ForecastList
import com.fei.kotlindemo.domain.result.Forecast
import com.fei.kotlindemo.domain.result.ForecastResult
import com.fei.kotlindemo.domain.model.Forecast as ModeForecast

/**
 *
 * @ClassName: ForecastDataMapper
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/23 11:10
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/23 11:10
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class ForecastDataMapper(private val zipCode: Long) {

    fun convertForecastToList(forecastResult: ForecastResult): ForecastList {
        return ForecastList(
            zipCode,
            forecastResult.city.name,
            forecastResult.city.country,
            convertForecastList(forecastResult.list)
        )
    }

    private fun convertForecastList(list: List<Forecast>): List<ModeForecast> {
        return list.map {
            convertForecastToMode(it)
        }
    }

    private fun convertForecastToMode(it: Forecast): ModeForecast = ModeForecast(
        date = convertDate(it.dt),
        description = it.weather[0].description,
        high = it.temp.max.toInt(),
        low = it.temp.min.toInt(),
        iconUrl = generateIconUrl(it.weather[0].icon)
    )

    private fun generateIconUrl(icon: String): String {
        return "http://openweathermap.org/img/w/$icon.png"
    }

    private fun convertDate(dt: Long): Long {
//        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
//        return df.format(dt * 1000)
        return dt
    }

}

package com.fei.kotlindemo.domain.mapper

import com.fei.kotlindemo.domain.model.ForecastList
import com.fei.kotlindemo.domain.response.Forecast
import com.fei.kotlindemo.domain.response.ForecastResult
import java.text.DateFormat
import java.util.*
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
class ForecastDataMapper {

    fun convertForecastToList(forecastResult: ForecastResult): ForecastList {
        return ForecastList(
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
        convertDate(it.dt), it.weather[0].description, it.temp.max.toInt(), it.temp.min.toInt(),generateIconUrl(it.weather[0].icon)
    )

    private fun generateIconUrl(icon: String): String {
        return "http://openweathermap.org/img/w/$icon.png"
    }

    private fun convertDate(dt: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(dt * 1000)
    }

}

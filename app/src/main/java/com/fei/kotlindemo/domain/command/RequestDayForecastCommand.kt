package com.fei.kotlindemo.domain.command

import com.fei.kotlindemo.domain.model.Forecast
import com.fei.kotlindemo.provider.ForecastProvider

class RequestDayForecastCommand(
    private val id: Long,
    private val forecastProvider: ForecastProvider = ForecastProvider()
) {
    fun execute(): Forecast {
       return forecastProvider.requestForecast(id)
    }

}

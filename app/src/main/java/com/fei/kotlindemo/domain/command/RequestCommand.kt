package com.fei.kotlindemo.domain.command

import com.fei.kotlindemo.domain.mapper.ForecastDataMapper
import com.fei.kotlindemo.domain.model.ForecastList
import com.fei.kotlindemo.domain.request.ForecastRequest

/**
 *
 * @ClassName: RequestCommand
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/23 11:14
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/23 11:14
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class RequestCommand(private val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertForecastToList(forecastRequest.execute())
    }
}
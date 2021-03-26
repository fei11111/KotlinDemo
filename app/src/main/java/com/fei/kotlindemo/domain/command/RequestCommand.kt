package com.fei.kotlindemo.domain.command

import com.fei.kotlindemo.domain.model.ForecastList
import com.fei.kotlindemo.provider.ForecastProvider

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
class RequestCommand(
    private val zipCode: Long,
    private val provider: ForecastProvider = ForecastProvider()
) :
    Command<ForecastList> {

    companion object {
        const val DAYS = 7
    }

    override fun execute(): ForecastList? {
        return provider.requestByZipCode(zipCode, DAYS)
    }
}
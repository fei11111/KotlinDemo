package com.fei.kotlindemo.`interface`

import com.fei.kotlindemo.domain.model.ForecastList

/**
 *
 * @ClassName: ForecastDataSource
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/26 10:26
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/26 10:26
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
/**
 * 获取数据接口，可以从网络获取，可以从数据库获取
 */
interface ForecastDataSource {

    fun requestForecastByZipCode(zipCode: Long, date: Long):ForecastList?

}
package com.fei.kotlindemo.db.model

/**
 *
 * @ClassName: DayForecast
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/25 9:33
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/25 9:33
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class DayForecast(private val map: MutableMap<String, Any?>) {

    var _id:Long by map
    var date:Long by map
    var description:String by map
    var high:Int by map
    var low:Int by map
    var iconUrl:String by map
    var cityId:Long by map

    constructor(
        date: Long,
        description: String,
        high: Int,
        low: Int,
        iconUrl: String,
        cityId: Long
    ) : this(HashMap()) {
        this.date = date
        this.description = description
        this.high = high
        this.low = low
        this.iconUrl = iconUrl
        this.cityId = cityId
    }
}
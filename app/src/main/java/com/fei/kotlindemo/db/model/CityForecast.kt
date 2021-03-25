package com.fei.kotlindemo.db.model

/**
 *
 * @ClassName: CityForecast
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/25 9:29
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/25 9:29
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class CityForecast(
    val map: MutableMap<String, Any?>,
    val dailyForecast: List<DayForecast>
) {

    var _id: Long by map
    var city: String by map
    var country: String by map

    constructor(_id: Long, city: String, country: String, dailyForecast: List<DayForecast>) : this(
        HashMap(),
        dailyForecast
    ) {
        this._id = _id
        this.city = city
        this.country = country
    }


}
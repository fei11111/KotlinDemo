package com.fei.kotlindemo.delegate

import com.fei.kotlindemo.property.NotNullSingleProperty
import kotlin.properties.ReadWriteProperty

/**
 *
 * @ClassName: DelegateExt
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/24 11:32
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/24 11:32
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
//单列对象
object DelegateExt {

    fun <T> notNullSingleValue(): ReadWriteProperty<Any?, T> = NotNullSingleProperty()

}
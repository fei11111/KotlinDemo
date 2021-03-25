package com.fei.kotlindemo.property

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *
 * @ClassName: NotNullSingleProperty
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/24 11:26
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/24 11:26
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class NotNullSingleProperty<R, T> : ReadWriteProperty<R, T> {

    private var value: T? = null

    override fun getValue(thisRef: R, property: KProperty<*>): T {
        return this.value ?: throw IllegalStateException("${property.name} not initialized")
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: T) {
        if (value == null) this.value = value else throw IllegalStateException(
            "${property.name} already initialized"
        )
    }
}
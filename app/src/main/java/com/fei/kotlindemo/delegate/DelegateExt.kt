package com.fei.kotlindemo.delegate

import android.content.Context
import com.fei.kotlindemo.property.NotNullSingleProperty
import com.fei.kotlindemo.util.SharePreference
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

    fun <T> sharePreference(context: Context, name: String, defaultValue: T) =
        SharePreference(context, name, defaultValue)


}
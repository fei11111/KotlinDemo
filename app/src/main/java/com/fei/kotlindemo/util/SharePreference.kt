package com.fei.kotlindemo.util

import android.content.Context
import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *
 * @ClassName: SharePreference
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/29 11:12
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/29 11:12
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class SharePreference<T>(
    private val context: Context,
    private val name: String,
    private val defaultValue: T
) :
    ReadWriteProperty<Any?, T> {

    private val preference: SharedPreferences by lazy {
        context.getSharedPreferences("default", Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return when (defaultValue) {
            is Long -> preference.getLong(name, defaultValue) as T
            is Int -> preference.getInt(name, defaultValue) as T
            is Float -> preference.getFloat(name, defaultValue) as T
            is Boolean -> preference.getBoolean(name, defaultValue) as T
            is String -> preference.getString(name, defaultValue.toString()).toString() as T
            else -> throw IllegalArgumentException("this type can not be saved into Preferences")
        }
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        when (defaultValue) {
            is Long -> preference.edit().putLong(name, defaultValue).apply()
            is Int -> preference.edit().putInt(name, defaultValue).apply()
            is Float -> preference.edit().putFloat(name, defaultValue).apply()
            is Boolean -> preference.edit().putBoolean(name, defaultValue).apply()
            is String -> preference.edit().putString(name, defaultValue.toString()).toString()
            else -> throw IllegalArgumentException("this type can not be saved into Preferences")
        }
    }


}
package com.fei.kotlindemo.extension

/**
 *
 * @ClassName: MutableMap
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/25 14:24
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/25 14:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
fun <K, V : Any> MutableMap<K, V>.toVarargArray(): Array<out Pair<K, V>> {
    return map {
        Pair(it.key, it.value!!)
    }.toTypedArray()
}
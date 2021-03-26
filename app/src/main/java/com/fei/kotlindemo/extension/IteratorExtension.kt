package com.fei.kotlindemo.extension

/**
 *
 * @ClassName: IteratableExtension
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/26 10:37
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/26 10:37
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
inline fun <T, R> Iterable<T>.firstResult(predicate: (T) -> R?): R {
    for (element in this) {
        val result: R? = predicate(element)
        if (result != null) return result
    }
    throw NoSuchElementException("No element matching predicate was found")
}
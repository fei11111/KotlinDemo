package com.fei.kotlindemo.extension

import java.text.DateFormat
import java.util.*

/**
 *
 * @ClassName: LongExtension
 * @Description: java类作用描述
 * @Author: Fei
 * @CreateDate: 2021-03-28 19:07
 * @UpdateUser: 更新者
 * @UpdateDate: 2021-03-28 19:07
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

inline fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String? {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}

package com.fei.kotlindemo.extension

import android.content.Context
import androidx.core.content.ContextCompat

/**
 *
 * @ClassName: ContextExtension
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/29 9:39
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/29 9:39
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
inline fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)
package com.fei.kotlindemo.extension

import android.content.Context
import android.view.View

/**
 *
 * @ClassName: ViewExtension
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/23 16:14
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/23 16:14
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
val View.ctx: Context
    get() = context

inline fun View.slideExit() {
    if (translationY == 0f) {
        animate().translationY(-height.toFloat())
    }
}

inline fun View.slideEnter() {
    if (translationY < 0) {
        animate().translationY(0f)
    }
}
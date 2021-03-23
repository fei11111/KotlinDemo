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
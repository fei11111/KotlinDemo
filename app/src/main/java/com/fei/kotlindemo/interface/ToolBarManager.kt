package com.fei.kotlindemo.`interface`

import android.graphics.drawable.Drawable
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.appcompat.widget.Toolbar
import com.fei.kotlindemo.App
import com.fei.kotlindemo.R
import com.fei.kotlindemo.extension.ctx
import org.jetbrains.anko.toast

/**
 *
 * @ClassName: ToolBarManager
 * @Description: java类作用描述
 * @Author: Fei
 * @CreateDate: 2021-03-28 21:44
 * @UpdateUser: 更新者
 * @UpdateDate: 2021-03-28 21:44
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
interface ToolBarManager {
    val toolBar: Toolbar
    var toolbarTitle: String
        get() = toolBar.title.toString()
        set(value) {
            toolBar.title = value
        }

    fun initToolbar() {
        toolBar.inflateMenu(R.menu.menu_main)
        toolBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_setting -> App.instance.toast("setting")
                else -> App.instance.toast("unknow option")
            }
            true
        }
    }

    fun enableHomeAsUp(up: () -> Unit) {
        toolBar.navigationIcon = createUpDrawable()
        toolBar.setNavigationOnClickListener {
            up()
        }
    }

    fun createUpDrawable(): Drawable  = with(DrawerArrowDrawable(toolBar.ctx)) {
        progress = 1f
        this
    }
}
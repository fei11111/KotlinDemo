package com.fei.kotlindemo

import android.app.Application
import com.fei.kotlindemo.delegate.DelegateExt

/**
 *
 * @ClassName: App
 * @Description: java类作用描述
 * @Author: Fei
 * @CreateDate: 2021-03-23 21:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2021-03-23 21:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class App : Application() {

    companion object {
        //保证只有唯一一次赋值，且获取数据时没有数据会报错
        var instance: Application by DelegateExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}
package com.fei.kotlindemo.domain.command

/**
 *
 * @ClassName: Command
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/23 10:37
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/23 10:37
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
open interface Command<T> {

    fun execute():T?

}
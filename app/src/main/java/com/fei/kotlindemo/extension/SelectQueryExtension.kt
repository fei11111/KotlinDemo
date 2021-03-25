package com.fei.kotlindemo.extension

import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SelectQueryBuilder

/**
 *
 * @ClassName: SelectQueryExtension
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/25 10:57
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/25 10:57
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
fun <T : Any> SelectQueryBuilder.parseList(
    parser: (Map<String, Any?>) -> T
): List<T> =
    parseList(object : MapRowParser<T> {
        override fun parseRow(columns: Map<String, Any?>): T {
            return parser(columns)
        }
    })

fun <T : Any> SelectQueryBuilder.parseOpt(
    parser: (Map<String, Any?>) -> T
): T? = parseOpt(
    object : MapRowParser<T> {
        override fun parseRow(columns: Map<String, Any?>): T {
            return parser(columns)
        }
    })

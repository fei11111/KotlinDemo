package com.fei.kotlindemo.db.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.fei.kotlindemo.App
import com.fei.kotlindemo.db.table.CityForecastTable
import com.fei.kotlindemo.db.table.DayForecastTable
import org.jetbrains.anko.db.*

/**
 *
 * @ClassName: ForecastDbHelper
 * @Description: java类作用描述
 * @Author: Fei
 * @CreateDate: 2021-03-24 20:24
 * @UpdateUser: 更新者
 * @UpdateDate: 2021-03-24 20:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class ForecastDbHelper(ctx: Context = App.instance) :
    ManagedSQLiteOpenHelper(ctx, DB_NAME, null, DB_VERSION) {

    companion object {
        const val DB_NAME = "forecast.db"
        const val DB_VERSION = 1
        val instance: ForecastDbHelper by lazy { ForecastDbHelper() }
    }

    override fun onCreate(db: SQLiteDatabase) {

        /***
         *
         * to 代替 Pair(A,B)
         *
         */

        db.run {
            createTable(
                CityForecastTable.NAME, true,
                /**
                 * SqlType + SqlTypeModifier 用了扩展操作符
                 */
                CityForecastTable.ID to INTEGER + PRIMARY_KEY,
                CityForecastTable.CITY to TEXT,
                CityForecastTable.COUNTRY to TEXT
            )
            createTable(
                DayForecastTable.NAME, true,
                DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                DayForecastTable.ID to INTEGER,
                DayForecastTable.DATE to INTEGER,
                DayForecastTable.DESCRIPTION to TEXT,
                DayForecastTable.HIGH to INTEGER,
                DayForecastTable.LOW to INTEGER,
                DayForecastTable.ICON_URL to TEXT,
                DayForecastTable.CITY_ID to INTEGER
            )
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.run {
            dropTable(CityForecastTable.NAME, true)
            dropTable(DayForecastTable.NAME, true)
            onCreate(this)
        }
    }

}
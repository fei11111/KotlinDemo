package com.fei.kotlindemo.ui.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.fei.kotlindemo.R
import com.fei.kotlindemo.`interface`.ToolBarManager
import com.fei.kotlindemo.domain.command.RequestDayForecastCommand
import com.fei.kotlindemo.domain.model.Forecast
import com.fei.kotlindemo.extension.color
import com.fei.kotlindemo.extension.toDateString
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.textColor
import org.jetbrains.anko.uiThread
import java.text.DateFormat

open class DetailActivity : AppCompatActivity(), ToolBarManager {

    var id: Long? = null
    var title: String? = null

    companion object {
        const val ID = "ID"
        const val CITY_NAME = "CITY_NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initToolbar()
        title = intent.getStringExtra(CITY_NAME)
        toolbarTitle = title!!
        enableHomeAsUp {
            onBackPressed()
        }
        doAsync {
            val result = RequestDayForecastCommand(intent.getLongExtra(ID, -1)).execute()
            uiThread {
                bindForecast(result)
            }
        }

    }

    private fun bindForecast(
        result: Forecast
    ) = with(result) {
        Picasso.Builder(this@DetailActivity).build().load(iconUrl).into(icon)
        supportActionBar?.subtitle = date.toDateString(DateFormat.FULL)
        weatherDescription.text = description
        bindWeather(high to maxTemperature, low to minTemperature)
    }

    private fun bindWeather(vararg views: Pair<Int, TextView>) {
        views.map {
            it.second.text = it.first.toString()
            it.second.textColor = color(
                when (it.first) {
                    in -50..0 -> android.R.color.holo_red_dark
                    in 0..15 -> android.R.color.holo_orange_dark
                    else -> android.R.color.holo_green_dark
                }
            )
        }
    }

    override val toolBar: Toolbar by lazy {
        find<Toolbar>(R.id.toolbar)
    }


}


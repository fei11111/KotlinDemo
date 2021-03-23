package com.fei.kotlindemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fei.kotlindemo.domain.command.RequestCommand
import org.jetbrains.anko.async
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    private val items = listOf<String>(
        "Mon 6/23 - Sunny",
        "Tus 6/23 - Foggy",
        "Wed 6/23 - Cloudy",
        "Thurs 6/23 - Sunny"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val forecastList = find<RecyclerView>(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)

        async {
            val result = RequestCommand("94043").execute()
            uiThread {
                forecastList.adapter =
                    ForecastListAdapter(result) {
                        toast(it.date)
                    }
            }
        }


    }
}
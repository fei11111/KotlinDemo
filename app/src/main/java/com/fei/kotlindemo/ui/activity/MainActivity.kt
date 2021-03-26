package com.fei.kotlindemo.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.fei.kotlindemo.R
import com.fei.kotlindemo.domain.command.RequestCommand
import com.fei.kotlindemo.ui.adapter.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast

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
        forecastList.layoutManager = LinearLayoutManager(this)

        button.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        doAsync {
            val result = RequestCommand(94043).execute()
            if (result != null) {
                runOnUiThread {
                    forecastList.adapter =
                        ForecastListAdapter(result) {
                            toast(it.date.toString())
                        }
                }
            }

        }


    }
}
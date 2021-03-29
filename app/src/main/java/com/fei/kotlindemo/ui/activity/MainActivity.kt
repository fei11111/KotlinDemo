package com.fei.kotlindemo.ui.activity

import android.os.Bundle
import androidx.annotation.IntDef
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.fei.kotlindemo.R
import com.fei.kotlindemo.`interface`.ToolBarManager
import com.fei.kotlindemo.domain.command.RequestCommand
import com.fei.kotlindemo.ui.adapter.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class MainActivity() : AppCompatActivity(), ToolBarManager {

    override val toolBar: Toolbar by lazy {
        find<Toolbar>(R.id.toolbar)
    }
    private val items = listOf<String>(
        "Mon 6/23 - Sunny",
        "Tus 6/23 - Foggy",
        "Wed 6/23 - Cloudy",
        "Thurs 6/23 - Sunny"
    )

    @IntDef(value = [GREEN,RED])
    @Retention(AnnotationRetention.SOURCE)
    annotation class LightColors{

    }

    companion object{
        final const val RED = 1
        final const val GREEN = 2
    }

    private fun testColor(@LightColors value:Int) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testColor(13)
        initToolbar()
        forecastList.layoutManager = LinearLayoutManager(this)
        attachToScroll(forecastList)
        doAsync {
            val result = RequestCommand(94043).execute()
            if (result != null) {
                runOnUiThread {
                    forecastList.adapter =
                        ForecastListAdapter(result) {
                            startActivity<DetailActivity>(
                                DetailActivity.CITY_NAME to result.city,
                                DetailActivity.ID to it.id
                            )
                        }
                    toolbarTitle = "${result.city}(${result.country})"
                }
            }

        }


    }
}
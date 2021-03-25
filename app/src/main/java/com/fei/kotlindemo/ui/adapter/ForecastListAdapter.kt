package com.fei.kotlindemo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fei.kotlindemo.R
import com.fei.kotlindemo.domain.model.Forecast
import com.fei.kotlindemo.domain.model.ForecastList
import com.fei.kotlindemo.extension.ctx
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 *
 * @ClassName: ForecastListAdapter
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/23 10:15
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/23 10:15
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class ForecastListAdapter(
    private val weekForecast: ForecastList,
    private val onItemClick: (Forecast) -> Unit
) :
    RecyclerView.Adapter<ForecastListAdapter.ForecastListHolder>() {


    class ForecastListHolder(private val view: View, private val onItemClick: (Forecast) -> Unit) :
        RecyclerView.ViewHolder(view) {

        fun bind(forecast: Forecast) {
            with(forecast) {
                Picasso.Builder(view.ctx).build().load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxAndMin.text = "$low°~$high°"
                itemView.setOnClickListener {
                    onItemClick(this)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastListHolder {
        return ForecastListHolder(
            LayoutInflater.from(parent.ctx).inflate(
                R.layout.item_forecast,
                parent,
                false
            ),
            onItemClick
        )
    }

    override fun getItemCount(): Int = weekForecast.size()


    override fun onBindViewHolder(holder: ForecastListHolder, position: Int) {
        holder.bind(weekForecast[position])
    }


}
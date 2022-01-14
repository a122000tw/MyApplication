package com.study.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.study.myapplication.model.WeatherInfo
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class RecyclerViewAdapter(): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var items: List<WeatherInfo> = ArrayList<WeatherInfo>()
    fun setListData(items: List<WeatherInfo>) {
        this.items = items
    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val startTime = view.tv_startTime
        val endTime = view.tv_endTime
        val picture = view.iv_picture
        fun bind(photo: WeatherInfo,context: Context) {
            startTime.text = photo.startTime
            endTime.text = photo.endTime
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position], holder.itemView.context)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}
package com.study.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.study.myapplication.api.WeatherApi
import com.study.myapplication.manager.WeatherManager
import com.study.myapplication.model.WeatherInfo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter
            val divider = DividerItemDecoration(applicationContext, StaggeredGridLayoutManager.VERTICAL)
            addItemDecoration(divider)
        }
        GlobalScope.launch {
            val api = WeatherManager.instance.api
            val key = resources.getString(R.string.key)
            val weathers: List<WeatherInfo>? = api.getWeather(key).execute().body()

            runOnUiThread {
                recyclerViewAdapter.setListData(weathers!!)
                recyclerViewAdapter.notifyDataSetChanged()
            }

        }

    }
}
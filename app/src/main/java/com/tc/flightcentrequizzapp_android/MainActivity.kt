package com.tc.flightcentrequizzapp_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    private val flightAdapter = FlightAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitService = RetrofitService.getInstance()
        val flightRepo = FlightRepo(retrofitService)

        flightListRecyclerview.recycledViewPool.clear()
        flightListRecyclerview.layoutManager = LinearLayoutManager(this)
        flightListRecyclerview.adapter = flightAdapter

        viewModel.getAllMovies(flightRepo)
        viewModel.getFlightList().observe(this, Observer { flightAdapter.setFlights(it) })
    }
}
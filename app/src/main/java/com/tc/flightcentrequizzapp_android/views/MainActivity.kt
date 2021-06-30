package com.tc.flightcentrequizzapp_android.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tc.flightcentrequizzapp_android.*
import com.tc.flightcentrequizzapp_android.recyclerViewAdapters.FlightAdapter
import com.tc.flightcentrequizzapp_android.repos.FlightRepo
import com.tc.flightcentrequizzapp_android.retrofit.RetrofitService
import com.tc.flightcentrequizzapp_android.viewModels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    private val flightAdapter =
        FlightAdapter(
            this
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Trips";

        val retrofitService =
            RetrofitService.getInstance()
        val flightRepo =
            FlightRepo(retrofitService)

        flightListRecyclerview.recycledViewPool.clear()
        flightListRecyclerview.layoutManager = LinearLayoutManager(this)
        flightListRecyclerview.adapter = flightAdapter

        viewModel.getAllMovies(flightRepo)
        viewModel.getFlightList().observe(this, Observer { flightAdapter.setFlights(it) })
    }
}
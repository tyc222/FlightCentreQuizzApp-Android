package com.tc.flightcentrequizzapp_android.repos

import com.tc.flightcentrequizzapp_android.retrofit.RetrofitService

class FlightRepo constructor(private val retrofitService: RetrofitService) {

    suspend fun getAllFlights() = retrofitService.getAllFlights("media", "81d93056-9c7f-451d-94b6-3e88eb6fa9ad")

}
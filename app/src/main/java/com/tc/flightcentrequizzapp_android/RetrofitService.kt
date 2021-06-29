package com.tc.flightcentrequizzapp_android

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("developer-test-flights-list.json")
    suspend fun getAllFlights( @Query("alt") alt: String,  @Query("token") token: String) : Response<List<FlightModel>>
    companion object {
        var retrofitService: RetrofitService? = null
        fun getInstance(
        ) : RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://firebasestorage.googleapis.com/v0/b/flight-centre-brand.appspot.com/o/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }

    }
}
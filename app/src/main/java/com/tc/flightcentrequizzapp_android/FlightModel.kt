package com.tc.flightcentrequizzapp_android

data class FlightModel(
        val airline_code: String,
        val arrival_airport: String,
        val arrival_city: String,
        val arrival_date: String,
        val departure_airport: String,
        val departure_city: String,
        val departure_date: String,
        val flight_number: String,
        val id: Int,
        val scheduled_duration: String
)
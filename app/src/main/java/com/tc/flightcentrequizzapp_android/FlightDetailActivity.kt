package com.tc.flightcentrequizzapp_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_flight_detail.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class FlightDetailActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_detail)

        supportActionBar?.title = "Trips";

        val flightData: FlightModel = intent.getParcelableExtra("flightData")!!

        val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'.000'")
        val arriveDate = flightData.arrival_date
        val arriveDt = LocalDateTime.parse(arriveDate, dateTimeFormatter)
        val departDate = flightData.departure_date
        val departDt = LocalDateTime.parse(departDate, dateTimeFormatter)

        detailDepartAirport.text = flightData.departure_airport
        detailDepartCity.text = flightData.departure_city
        detailDepartDate.text = "${departDt.dayOfWeek.toString().subSequence(0,3)}, ${departDt.dayOfMonth} ${departDt.month}"
        detailDepartTime.text = "${departDt.hour}:${departDt.minute}"
        arriveDepartAirport.text = flightData.arrival_airport
        arriveDepartCity.text = flightData.arrival_city
        arriveDepartDate.text = "${arriveDt.dayOfWeek.toString().subSequence(0,3)}, ${arriveDt.dayOfMonth} ${arriveDt.month}"
        arriveDepartTime.text = "${arriveDt.hour}:${arriveDt.minute}"
        detailFlightNum.text = flightData.airline_code + flightData.flight_number
        detailTerminal.text = "D"
        detailGate.text = "--"
        detailSeat.text = "--"

    }
}
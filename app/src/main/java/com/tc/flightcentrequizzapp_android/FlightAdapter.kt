package com.tc.flightcentrequizzapp_android

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_flight.view.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class FlightAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var flightList = mutableListOf<FlightModel>()

    fun setFlights(flights: List<FlightModel>) {
        this.flightList = flights.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_flight, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val flight = flightList[position]

        val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'.000'")
        val arriveDate = flight.arrival_date
        val arriveDt = LocalDateTime.parse(arriveDate, dateTimeFormatter)
        val departDate = flight.departure_date
        val departDt = LocalDateTime.parse(departDate, dateTimeFormatter)
        
        holder.dateView.text = "${departDt.dayOfWeek.toString().subSequence(0,3)}, ${departDt.dayOfMonth} ${departDt.month}"
        holder.flightToView.text = "Flight to " + flight.arrival_city.split(',')[0]
        holder.arriveAirportView.text = flight.arrival_airport
        holder.arriveCityView.text = flight.arrival_city.split(',')[0]
        holder.arriveTimeView.text = "${arriveDt.hour}:${arriveDt.minute}"
        holder.departureAirportView.text = flight.departure_airport
        holder.departCityView.text = flight.departure_city.split(',')[0]
        holder.departTimeView.text = "${departDt.hour}:${departDt.minute}"
        holder.durationView.text = flight.scheduled_duration
        holder.flightTypeView.text = "Non-Stop"

        holder.bind(flight)
    }

    override fun getItemCount(): Int {
        return flightList.size
    }
}

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val dateView: TextView = itemView.findViewById(R.id.date)
    val arriveAirportView: TextView = itemView.findViewById(R.id.arriveAirport)
    val arriveCityView: TextView = itemView.findViewById(R.id.arriveCity)
    val arriveTimeView: TextView = itemView.findViewById(R.id.arriveTime)
    val durationView: TextView = itemView.findViewById(R.id.duration)
    val flightTypeView: TextView = itemView.findViewById(R.id.flightType)
    val departCityView: TextView = itemView.findViewById(R.id.departCity)
    val departTimeView: TextView = itemView.findViewById(R.id.departTime)
    val departureAirportView: TextView = itemView.findViewById(R.id.departureAirport)
    val flightToView: TextView = itemView.findViewById(R.id.flightTo)
class MainViewHolder(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView) {
    private val context = context
    val dateView: TextView = itemView.date
    val arriveAirportView: TextView = itemView.arriveAirport
    val arriveCityView: TextView = itemView.arriveCity
    val arriveTimeView: TextView = itemView.arriveTime
    val durationView: TextView = itemView.duration
    val flightTypeView: TextView = itemView.flightType
    val departCityView: TextView = itemView.departCity
    val departTimeView: TextView = itemView.departTime
    val departureAirportView: TextView = itemView.departureAirport
    val flightToView: TextView = itemView.flightTo

    fun bind(flightData: FlightModel) {
        itemView.flight.setOnClickListener { Log.e("ewf", flightData.toString()) }
    }
}
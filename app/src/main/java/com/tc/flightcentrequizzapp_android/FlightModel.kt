package com.tc.flightcentrequizzapp_android

import android.os.Parcel
import android.os.Parcelable

data class FlightModel (
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
) : Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readInt(),
                parcel.readString().toString()
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(airline_code)
                parcel.writeString(arrival_airport)
                parcel.writeString(arrival_city)
                parcel.writeString(arrival_date)
                parcel.writeString(departure_airport)
                parcel.writeString(departure_city)
                parcel.writeString(departure_date)
                parcel.writeString(flight_number)
                parcel.writeInt(id)
                parcel.writeString(scheduled_duration)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<FlightModel> {
                override fun createFromParcel(parcel: Parcel): FlightModel {
                        return FlightModel(parcel)
                }

                override fun newArray(size: Int): Array<FlightModel?> {
                        return arrayOfNulls(size)
                }
        }
}
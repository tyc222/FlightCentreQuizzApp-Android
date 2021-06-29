package com.tc.flightcentrequizzapp_android

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {

    private val loading = MutableLiveData<Boolean>()
    fun getLoading(): LiveData<Boolean> {
        return loading
    }
    fun setLoading(value: Boolean) {
        loading.value = value
    }

    private val flightList = MutableLiveData<List<FlightModel>>()
    fun getFlightList(): LiveData<List<FlightModel>> {
        return flightList
    }

    private var flightListJob: Job? = null

    fun getAllMovies(flightRepo: FlightRepo) {
        flightListJob = CoroutineScope(Dispatchers.IO).launch {
            val response = flightRepo.getAllFlights()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    flightList.postValue(response.body())
                    loading.value = false
                } else {
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        flightListJob?.cancel()
    }

}
package com.example.horocapp.data

import android.util.Log
import com.example.horocapp.data.network.HoroscopeApiService
import com.example.horocapp.domain.Repository
import com.example.horocapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService ):Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        kotlin.runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure {  Log.i("mizarra","Ha ocurrido un error ${it.message}") }
        return null
    }
}
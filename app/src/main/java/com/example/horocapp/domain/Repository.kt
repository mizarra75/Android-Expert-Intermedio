package com.example.horocapp.domain

import com.example.horocapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}
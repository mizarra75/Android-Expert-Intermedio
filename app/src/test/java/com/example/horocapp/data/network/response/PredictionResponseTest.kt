package com.example.horocapp.data.network.response

import com.example.horocapp.motherobject.HoroscopeMotherObject.anyResponse
import io.kotlintest.shouldBe
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class PredictionResponseTest{

    @Test
    fun `toDomain Should Return A Correct PredictionModel`(){
        //Given
        val horoscopeResponse = anyResponse

        //When
        val predictionModel = horoscopeResponse.toDomain()

        //Then
        predictionModel.sign shouldBe  horoscopeResponse.sign
         predictionModel.horoscope shouldBe horoscopeResponse.horoscope

    }
}
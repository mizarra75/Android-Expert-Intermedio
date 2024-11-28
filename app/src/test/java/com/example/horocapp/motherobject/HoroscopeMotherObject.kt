package com.example.horocapp.motherobject

import com.example.horocapp.data.network.response.PredictionResponse
import com.example.horocapp.domain.model.HoroscopeInfo.Aquarius
import com.example.horocapp.domain.model.HoroscopeInfo.Aries
import com.example.horocapp.domain.model.HoroscopeInfo.Cancer
import com.example.horocapp.domain.model.HoroscopeInfo.Capricorn
import com.example.horocapp.domain.model.HoroscopeInfo.Gemini
import com.example.horocapp.domain.model.HoroscopeInfo.Leo
import com.example.horocapp.domain.model.HoroscopeInfo.Libra
import com.example.horocapp.domain.model.HoroscopeInfo.Pisces
import com.example.horocapp.domain.model.HoroscopeInfo.Sagittarius
import com.example.horocapp.domain.model.HoroscopeInfo.Scorpio
import com.example.horocapp.domain.model.HoroscopeInfo.Taurus
import com.example.horocapp.domain.model.HoroscopeInfo.Virgo

object HoroscopeMotherObject {

    val anyResponse = PredictionResponse("date","prediction","taurus")

    var horoscopeInfoList = listOf(
        Aries,
        Taurus,
        Gemini,
        Cancer,
        Leo,
        Virgo,
        Libra,
        Scorpio,
        Sagittarius,
        Capricorn,
        Aquarius,
        Pisces
    )
}
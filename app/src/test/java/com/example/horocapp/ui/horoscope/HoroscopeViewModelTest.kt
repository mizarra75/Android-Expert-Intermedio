package com.example.horocapp.ui.horoscope

import com.example.horocapp.data.providers.HoroscopeProvider
import com.example.horocapp.motherobject.HoroscopeMotherObject.horoscopeInfoList
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class HoroscopeViewModelTest{

    @MockK
    lateinit var horoscopeProvider: HoroscopeProvider

    private lateinit var viewModel: HoroscopeViewModel

    @Before
    fun setUp(){
        MockKAnnotations.init(this, relaxUnitFun = true)

    }

    @Test
    fun `when viewmodel is created then horoscope are loaded`(){
        every { horoscopeProvider.getHoroscopes() } returns horoscopeInfoList
        viewModel = HoroscopeViewModel(horoscopeProvider)

        val horoscope = viewModel.horoscope.value

        assertTrue(horoscope.isNotEmpty())
    }
}
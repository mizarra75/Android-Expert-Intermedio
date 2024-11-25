package com.example.horocapp.ui.horoscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.horocapp.databinding.FragmentHoroscopeBinding
import com.example.horocapp.domain.model.HoroscopeInfo
import com.example.horocapp.domain.model.HoroscopeModel
import com.example.horocapp.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    private val horoscopeViewModel by viewModels<HoroscopeViewModel> ()
    private lateinit var horoscopeAdapter: HoroscopeAdapter

    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        initList()
        initUiState()
    }

    private fun initList() {
        horoscopeAdapter = HoroscopeAdapter(onItemSelected = {
             val type = when(it){
                HoroscopeInfo.Aquarius -> HoroscopeModel.Aquarius
                HoroscopeInfo.Aries -> HoroscopeModel.Aries
                HoroscopeInfo.Cancer -> HoroscopeModel.Cancer
                HoroscopeInfo.Capricorn -> HoroscopeModel.Capricorn
                HoroscopeInfo.Gemini -> HoroscopeModel.Gemini
                HoroscopeInfo.Leo -> HoroscopeModel.Leo
                HoroscopeInfo.Libra -> HoroscopeModel.Libra
                HoroscopeInfo.Pisces -> HoroscopeModel.Pisces
                HoroscopeInfo.Sagittarius -> HoroscopeModel.Sagittarius
                HoroscopeInfo.Scorpio -> HoroscopeModel.Scorpio
                HoroscopeInfo.Taurus -> HoroscopeModel.Taurus
                HoroscopeInfo.Virgo -> HoroscopeModel.Virgo
            }

            findNavController().navigate(HoroscopeFragmentDirections.actionHoroscopeFragmentToHoroscopeDetailActivity(type))
        })
        binding.rvHoroscope.layoutManager =  GridLayoutManager(context,2)
        binding.rvHoroscope.adapter = horoscopeAdapter
    }

    private fun initUiState() {
        //Crea una corutina que depende del ciclo de vida del fragment, es decir una vez muera el
        //fragment la coutina muere no importa si tiene procesos por ejecutar
        lifecycleScope.launch {
            //En lo que comience el ciclo de vida
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopeViewModel.horoscope.collect{
                    //Cambios en Horoscope
                    horoscopeAdapter.updateList(it)
                }

            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}
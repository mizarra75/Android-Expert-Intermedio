package com.example.horocapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.horocapp.databinding.ItemHoroscopeBinding
import com.example.horocapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit){
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.text = binding.tvTitle.context.getString(horoscopeInfo.name)
        binding.vhParent.setOnClickListener{
            startRotationAnimation(binding.ivHoroscope,newLambda = {onItemSelected(horoscopeInfo)})
        //    onItemSelected(horoscopeInfo)
        }

    }

    private fun startRotationAnimation(view:View, newLambda:()->Unit){
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction{ newLambda() }
            start()
        }

    }
}
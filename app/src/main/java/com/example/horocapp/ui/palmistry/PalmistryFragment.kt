package com.example.horocapp.ui.palmistry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.PermissionChecker
import com.example.horocapp.R
import com.example.horocapp.databinding.FragmentLuckBinding
import com.example.horocapp.databinding.FragmentPalmistryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PalmistryFragment : Fragment() {

    companion object{
        private const val CAMERA_PERMISSION = android.Manifest.permission.CAMERA
    }

    private var _binding: FragmentPalmistryBinding? = null
    private val binding get() = _binding!!
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()){
        if(it){

        }else{
            Toast.makeText(requireContext(),"Debes aceptar los permisos",Toast.LENGTH_LONG).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(checkCameraPermission()){
            //tiene permisos aceptados para la camara
        }else {
            requestPermissionLauncher.launch(CAMERA_PERMISSION)

        }

    }

    private fun checkCameraPermission(): Boolean {
        return PermissionChecker.checkSelfPermission(
            requireContext(),
            CAMERA_PERMISSION) == PermissionChecker.PERMISSION_GRANTED
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPalmistryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}
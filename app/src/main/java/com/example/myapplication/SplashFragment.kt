package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.SplashLayoutBinding

class SplashFragment : Fragment() {

    private lateinit var binding: SplashLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = SplashLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mbNavButton.setOnClickListener{
            val name = binding.etName.text
            if (!name.isNullOrBlank()){
                findNavController().navigate(SplashFragmentDirections.actionSplashFragment2ToHomeFragment2( "$name"))
            } else {
                Toast.makeText(requireContext(), "Veuilez entrer votre prénom svp", Toast.LENGTH_LONG).show()
            }
        }
    }
}
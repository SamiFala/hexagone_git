package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.SplashLayoutBinding

class SplashFragment : Fragment() {

    private lateinit var binding: SplashLayoutBinding
    private val viewModel: MainViewModel by activityViewModels()

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
        viewModel.getAllCountries()
        binding.mbNav.setOnClickListener {
            val name = binding.etName.text.toString()
            if (!name.isNullOrBlank()) {
                findNavController().navigate(
                    SplashFragmentDirections.actionSplashFragmentToHomeFragment(
                        name
                    )
                )
            } else {
                Toast.makeText(requireContext(), " veuillez entrer votre nom", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

}
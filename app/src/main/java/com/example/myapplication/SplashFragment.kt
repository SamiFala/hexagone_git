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

    private lateinit var binding: SplashLayoutBinding  //la var binding nous permet d'interagir avec tout ce qui existe dans splash layout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = SplashLayoutBinding.inflate(inflater, container, false)
        return binding.root
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mbNavigation.setOnClickListener {
            val name = binding.etName.text.toString()

            if (!name.isNullOrBlank()) {
                findNavController().navigate(
                    SplashFragmentDirections.actionSplashFragmentToHomeFragment(
                        name
                    )
                )
            } else {
                Toast.makeText(
                    requireContext(),
                    "Veuillez saisir votre nom pour naviguer",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}


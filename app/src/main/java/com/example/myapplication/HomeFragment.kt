package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

import com.example.myapplication.databinding.HomeLayoutBinding
import com.example.myapplication.databinding.SplashLayoutBinding

class HomeFragment : Fragment() {


    private lateinit var binding: HomeLayoutBinding //la var binding nous permet d'interagir avec tout ce qui existe dans splash layout
    private val navArgs: HomeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = HomeLayoutBinding.inflate(inflater, container, false)
        return binding.root


        }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvTitle.text = getString(R.string.bonjour_s_et_bienvenue_sur_l_app, navArgs.name)
    }
}
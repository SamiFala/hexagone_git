package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.HomeLayoutBinding
import com.example.myapplication.databinding.SplashLayoutBinding

class HomeFragment : Fragment () {

        private lateinit var binding: HomeLayoutBinding
        private val navArgs : HomeFragmentArgs by navArgs()
        private val viewModel : MainViewModel by activityViewModels ()

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
        //var count = 0
        binding.tvTitle.text = getString(R.string.bonjour_s_bienvenue_dans_mon_app_vous_tes_la_visite_n_s, navArgs.name, viewModel.count.value.toString())

        // L'observeur : il observe la valeur de count et modifie en conséquence
        viewModel.count.observe(viewLifecycleOwner, Observer{
            binding.tvTitle.text = getString(R.string.bonjour_s_bienvenue_dans_mon_app_vous_tes_la_visite_n_s, navArgs.name, viewModel.count.value.toString())
        })

        binding.mbPlus.setOnClickListener {
            viewModel.plus()
        }
        binding.mbMoins.setOnClickListener {
            viewModel.moins()
        }
        binding.mbReset.setOnClickListener {
            viewModel.reset()
        }
    }
}



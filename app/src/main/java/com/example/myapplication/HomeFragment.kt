package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.HomeLayoutBinding

class HomeFragment : Fragment() {

    private lateinit var binding: HomeLayoutBinding
    private val navArgs: HomeFragmentArgs by navArgs()
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = HomeLayoutBinding.inflate(inflater,container, false)
        return binding.root
        //return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTitle.text = getString(R.string.this_s_is_a_home_layout, navArgs.name, viewModel.count.value.toString())

        viewModel.count.observe(viewLifecycleOwner, Observer {
            binding.tvTitle.text = getString(R.string.this_s_is_a_home_layout, navArgs.name, viewModel.count.value.toString())
        })

        binding.mbPlus.setOnClickListener {
            viewModel.plus()
        }

        binding.mbMoins.setOnClickListener {
            viewModel.minus()
            //if (viewModel.count.value?.minus(1)!! < 0) {
               // viewModel.count.value = 0
           // }
        }
        binding.mbReset.setOnClickListener {
            viewModel.reset()
        }

        viewModel.error.observe(viewLifecycleOwner, Observer {
            if (it){
                Toast.makeText(requireContext(), "Une erreur est survenue", Toast.LENGTH_LONG).show()
            }
        })


    }
}
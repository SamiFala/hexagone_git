package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.HomeLayoutBinding

class HomeFragment : Fragment() {

    private lateinit var binding: HomeLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = HomeLayoutBinding.inflate(inflater,container, false)
        return binding.root
        //return super.onCreateView(inflater, container, savedInstanceState)
    }
}
package com.example.shopingapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shopingapp.R
import com.example.shopingapp.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private var _binding:FragmentCartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      _binding = FragmentCartBinding.inflate(inflater,
          container,
          false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       //here we will be writing stuffs
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
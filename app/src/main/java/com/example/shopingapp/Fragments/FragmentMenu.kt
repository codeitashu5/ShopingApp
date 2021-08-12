package com.example.shopingapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopingapp.R
import com.example.shopingapp.databinding.FragmentMenuBinding
import com.example.shopingapp.recycler.CustomAdapter
import com.example.shopingapp.recycler.Lists
import com.example.shopingapp.recycler.OnButtonClick


class FragmentMenu : Fragment(),OnButtonClick {

    private  var _binding:FragmentMenuBinding? = null
    private val binding = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater,
            container,
            false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //here we will do our work
        binding.recyclerView.adapter = CustomAdapter(Lists().createList(),this)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onButtonClicked() {
        TODO("Not yet implemented")
    }

}
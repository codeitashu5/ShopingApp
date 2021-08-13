package com.example.shopingapp.Fragments

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopingapp.R
import com.example.shopingapp.databinding.FragmentMenuBinding
import com.example.shopingapp.recycler.CustomAdapter
import com.example.shopingapp.recycler.Lists
import com.example.shopingapp.recycler.OnButtonClick
import com.example.shopingapp.viewModels.MenuViewModel


class FragmentMenu : Fragment(), OnButtonClick {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    lateinit var recyclerView: RecyclerView

    //delegating the viewModel
    private val viewModel : MenuViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(
            inflater,
            container,
            false
        )
        //it is required to give your created options menu
        setHasOptionsMenu(true)

        //adding observer for price
        viewModel.price.observe(viewLifecycleOwner,{ newValue->
            binding.priceTotal.text = getString(R.string.total,newValue)
        })

        //adding observer for jerseys
        viewModel.jerseys.observe(viewLifecycleOwner,{ newValue->
            binding.jerseyTotal.text = getString(R.string.quantity,newValue)
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //here we will do our work
        recyclerView = binding.recyclerView

        recyclerView.adapter = CustomAdapter(Lists().createList(), this)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())



    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.app_bar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.cart -> {
                //code to be written
                val action = FragmentMenuDirections.actionFragmentMenuToCartFragment()
                findNavController().navigate(action)
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onButtonClicked(b:Boolean) {
       if(b){
           viewModel.increaseJerseys()
           viewModel.increasePrice()
       }
        else{
            viewModel.decreaseJerseys()
            viewModel.decreasePrice()
       }
    }

}
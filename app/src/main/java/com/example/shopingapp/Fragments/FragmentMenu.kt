package com.example.shopingapp.Fragments

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopingapp.R
import com.example.shopingapp.databinding.FragmentMenuBinding
import com.example.shopingapp.recycler.CustomAdapter
import com.example.shopingapp.recycler.Lists
import com.example.shopingapp.recycler.OnButtonClick


class FragmentMenu : Fragment(),OnButtonClick {

    private  var _binding:FragmentMenuBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater,
            container,
            false)
        //it is required to give your created options menu
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //here we will do our work
        binding.recyclerView.adapter = CustomAdapter(Lists().createList(),this)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())


        binding.recyclerView.setOnClickListener {

        }


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.app_bar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.cart->{
                //code to be written
                val action = FragmentMenuDirections.actionFragmentMenuToCartFragment()
                findNavController().navigate(action)
                true
            }
            else->{
                super.onOptionsItemSelected(item)
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onButtonClicked() {
        Toast.makeText(requireContext(), "added", Toast.LENGTH_SHORT).show()
    }

}
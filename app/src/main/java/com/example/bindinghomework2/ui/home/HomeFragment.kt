package com.example.bindinghomework2.ui.home

import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bindinghomework2.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    private lateinit var itemView: View
    private lateinit var homeViewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        itemView = inflater.inflate(R.layout.fragment_home, container, false)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        init()
        return itemView
    }

    private fun init(){
        homeViewModel.initCount()

        homeViewModel.count().observe(viewLifecycleOwner, Observer {
            textValue.text = it.toString()
        })

        itemView.increaseButton.setOnClickListener {
            homeViewModel.increase()
        }

        itemView.decreaseButton.setOnClickListener {
            homeViewModel.decrease()
        }
    }
}
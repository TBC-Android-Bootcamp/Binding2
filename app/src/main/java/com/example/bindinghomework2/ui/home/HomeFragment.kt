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


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        init()
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun init(){
        homeViewModel.initCount()

        homeViewModel.count().observe(viewLifecycleOwner, Observer {
            value.text = it.toString()
        })

        //minusButton.setOnClickListener {
        //    homeViewModel.decrease()
        //}
    }

}
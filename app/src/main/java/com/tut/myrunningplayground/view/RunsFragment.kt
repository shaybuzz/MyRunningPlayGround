package com.tut.myrunningplayground.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.tut.myrunningplayground.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_run.*

@AndroidEntryPoint
class RunsFragment:Fragment(R.layout.fragment_run) {

    val runsViewModel:RunsViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab.setOnClickListener {
            findNavController().navigate(R.id.action_runsFragment_to_trackingFragment)
        }
    }
}
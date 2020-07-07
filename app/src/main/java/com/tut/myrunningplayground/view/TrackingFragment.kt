package com.tut.myrunningplayground.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tut.myrunningplayground.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrackingFragment:Fragment(R.layout.fragment_tracking) {
    val runsViewModel:RunsViewModel by viewModels()

}
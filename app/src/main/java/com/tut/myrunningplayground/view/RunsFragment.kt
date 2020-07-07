package com.tut.myrunningplayground.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tut.myrunningplayground.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RunsFragment:Fragment(R.layout.fragment_run) {

    val runsViewModel:RunsViewModel by viewModels()
}
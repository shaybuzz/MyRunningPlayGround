package com.tut.myrunningplayground.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tut.myrunningplayground.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatisticsFragment : Fragment(R.layout.fragment_statistics) {
    val runsViewModel: StatisticsViewModel by viewModels()
}
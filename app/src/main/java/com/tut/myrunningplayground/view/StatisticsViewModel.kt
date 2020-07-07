package com.tut.myrunningplayground.view

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.tut.myrunningplayground.repositories.RunRepository

class StatisticsViewModel @ViewModelInject constructor(private val runRepository: RunRepository) :
    ViewModel() {


}
package com.tut.myrunningplayground.view

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tut.myrunningplayground.db.entity.Run
import com.tut.myrunningplayground.repositories.RunRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class RunsViewModel @ViewModelInject constructor(private val runRepository: RunRepository) :
    ViewModel() {
    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            val runs = runRepository.getRunsByDate()
            Timber.d("#### view model fetch runs ${runs.value}")
        }
    }

    fun add(run: Run) {
        viewModelScope.launch {
            runRepository.upsert(run)
        }

    }


}
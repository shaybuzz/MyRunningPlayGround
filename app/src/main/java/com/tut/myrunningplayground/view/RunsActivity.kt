package com.tut.myrunningplayground.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.tut.myrunningplayground.R
import com.tut.myrunningplayground.db.entity.Run
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RunsActivity : AppCompatActivity() {

    private val runsViewModel: RunsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        runsViewModel.add(Run(null, 4, 4, 4, 5, 6f))
//        runsViewModel.add(Run(null, 74, 64, 54, 55, 6f))
//
//        runsViewModel.fetchData()

    }
}
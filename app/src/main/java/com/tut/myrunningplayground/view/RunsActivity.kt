package com.tut.myrunningplayground.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.tut.myrunningplayground.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class RunsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        bottomNavigationView.setupWithNavController(navHostFragment.findNavController())

        navHostFragment.findNavController()
            .addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.settingsFragment, R.id.statisticsFragment, R.id.runsFragment -> bottomNavigationView.visibility =
                        View.VISIBLE
                    else -> bottomNavigationView.visibility = View.GONE
                }
            }

    }
}
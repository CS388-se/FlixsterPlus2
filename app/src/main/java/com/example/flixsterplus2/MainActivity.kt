package com.example.flixsterplus2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.flixsterplus2.R.id

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val supportFragmentManager = supportFragmentManager
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(id.movieContent, MoviesFragment(), null)
        fragmentTransaction.replace(id.tvShowContent, TvShowsFragment(), null).commit()
    }
}

package com.eldiro.retrofitmoviemvvm.views

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.eldiro.retrofitmoviemvvm.databinding.ActivityMovieSplashBinding

/**
 * Created by Eldiro on 24/01/24.
 * Apakah kamu yakin ini bekerja dengan baik?
 */
class SplashScreen: AppCompatActivity() {
    private var _binding: ActivityMovieSplashBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMovieSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(mainLooper).postDelayed({
            startActivity(Intent(this,MovieList::class.java))
            finish()
        }, 1000)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

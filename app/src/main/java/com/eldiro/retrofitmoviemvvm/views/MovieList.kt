package com.eldiro.retrofitmoviemvvm.views

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.eldiro.retrofitmoviemvvm.adapter.MovieListAdapter
import com.eldiro.retrofitmoviemvvm.api.RequestState
import com.eldiro.retrofitmoviemvvm.databinding.ActivityMovieListBinding
import com.eldiro.retrofitmoviemvvm.viewmodels.MovieViewModel

/**
 * Created by Eldiro on 24/01/24.
 * Apakah kamu yakin ini bekerja dengan baik?
 */
class MovieList: AppCompatActivity() {

    private var _binding: ActivityMovieListBinding? = null
    private val binding get() = _binding!!
    private var adapter: MovieListAdapter? = null
    private var layoutManager: LayoutManager? = null
    private val viewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMovieListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        observeAnychangePopularMovie()
    }

    //implementasi popularMovie
    private fun observeAnychangePopularMovie(){
        //prosess request dan mendapatkan response dari yang di observe itu
        viewModel.getPopularMovie().observe(this) {
            Log.d("FETCH DATA", it.toString())
//            if (it != null) {
//                when (it) {
//                    is RequestState.Loading -> showLoading()
//                    is RequestState.Success -> {
//                        hideLoading()
//                        it.data.results.let { data->
//                            if (data != null) {
//                                adapter?.setMovies(data)
//                            }
//                        }
//                    }
//                    is RequestState.Error -> {
//                        hideLoading()
//                        Toast.makeText(this,it.message, Toast.LENGTH_LONG).show()
//                    }
//                }
//            }
        }
    }

    private fun setupRecyclerView(){
        adapter = MovieListAdapter()
        layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        binding.apply {
            movieList.adapter= adapter
            movieList.layoutManager = layoutManager
        }
    }

    private fun showLoading(){
        binding.loading.show()
    }
    private fun hideLoading(){
        binding.loading.hide()
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}

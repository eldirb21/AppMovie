package com.eldiro.retrofitmoviemvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eldiro.retrofitmoviemvvm.BuildConfig
import com.eldiro.retrofitmoviemvvm.databinding.MovieListBinding
import com.eldiro.retrofitmoviemvvm.models.Movie

/**
 * Created by Eldiro on 25/01/24.
 * Apakah kamu yakin ini bekerja dengan baik?
 */

//Meng inherite dari RecyclerView
class MovieListAdapter(): RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {
    private val movieList = ArrayList<Movie>()

    fun setMovies(list: List<Movie>){
        //setiap data dapet dari response data sebelumnya di clear terlebih dahulu setelah itu baru di masukan data baru
        this.movieList.clear()
        this.movieList.addAll(list)
    }

    inner class ViewHolder(val binding: MovieListBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MovieListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    //mendapatkan jumlah data di dalam Movie
    override fun getItemCount(): Int =movieList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(movieList[position]){
                binding.apply {
                    title.text = originalTitle
                    lang.text = originalLanguage
                    releaseDate.text = releaseDate.toString()
                    ratingBar.rating = voteAverage ?: 0f
                    ratingText.text = voteCount.toString()

                    Glide.with(itemView).load("${BuildConfig.PHOTO_BASE_URL}$posterPath").into(poster)
                }
            }
        }
    }

}

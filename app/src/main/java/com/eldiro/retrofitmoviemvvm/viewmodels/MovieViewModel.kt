package com.eldiro.retrofitmoviemvvm.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.eldiro.retrofitmoviemvvm.api.RequestState
import com.eldiro.retrofitmoviemvvm.models.MovieResponse
import com.eldiro.retrofitmoviemvvm.repositories.MovieRepository
import retrofit2.HttpException

/**
 * Created by Eldiro on 24/01/24.
 * Apakah kamu yakin ini bekerja dengan baik?
 */
class MovieViewModel: ViewModel() {

    private val repo : MovieRepository = MovieRepository()
    private val page = 1

    //mengembalikan nilai dari RequestState dari MovieResponse
    fun getPopularMovie(): LiveData<RequestState<MovieResponse>> =  liveData {
        //untuk menghandle loading data sebelum mendapatkan respon dari http
        emit(RequestState.Loading)

        try {
            //Fetch Success
            val response = repo.getPopularMovie(page)
            emit(RequestState.Success(response))

        }catch (e:HttpException){
            Log.d("ERROR", e.toString())
            //Fetch Failed
            e.response()?.errorBody()?.string()?.let { RequestState.Error(it) }?.let { emit((it)) }
        }
    }

}

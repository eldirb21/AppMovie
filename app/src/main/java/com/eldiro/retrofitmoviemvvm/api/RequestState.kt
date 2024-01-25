package com.eldiro.retrofitmoviemvvm.api

/**
 * Created by Eldiro on 24/01/24.
 * Apakah kamu yakin ini bekerja dengan baik?
 */
sealed class RequestState<out T> private constructor(){
    data class Success<out T> (val data: T):RequestState<T>()
    data class Error(val message:String) : RequestState<Nothing>()
    object Loading: RequestState<Nothing>()
}

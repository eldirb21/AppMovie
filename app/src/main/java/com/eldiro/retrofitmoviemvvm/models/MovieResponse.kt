package com.eldiro.retrofitmoviemvvm.models

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class MovieResponse(

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("total_pages")
	val totalPages: Int? = null,

	@field:SerializedName("results")
	val results: List<Movie>? = null,

	@field:SerializedName("total_results")
	val totalResults: Int? = null
) : Parcelable
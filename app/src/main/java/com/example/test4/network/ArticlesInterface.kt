package com.example.test4.network

import com.example.test4.models.NewsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticlesInterface {

    @GET("top-headlines")
    fun getArticoes(@Query("country") country: String,
                    @Query("apiKey")apiKey: String): Call<NewsModel>


}
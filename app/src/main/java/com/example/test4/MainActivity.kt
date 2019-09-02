package com.example.test4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.test4.common.Constants
import com.example.test4.models.NewsModel
import com.example.test4.network.ArticlesInterface
import com.example.test4.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val articlesRequest = RetrofitInstance().retrofitInstance.create(ArticlesInterface::class.java)
        val call = articlesRequest.getArticoes(Constants.COUNTRY, Constants.API_KEY)

        call.enqueue(object : Callback<NewsModel> {
            override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                Log.d("masage", "error"+t.message)
            }

            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                val res = response.body()

                Log.d("Title", ""+res!!.articles[0].title)

                //views?.showArticles(res!!)

            }

        });


    }
}

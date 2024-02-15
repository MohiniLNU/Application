package com.userinterface.myappmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMovies()
    }

    private fun getMovies() {
      val movieLo=movieService.movieInst.getmovies(api_key="f526406d7c8826c6072d1f58e8f773f8")

        movieLo.enqueue(object : Callback<mymovie?> {
            override fun onResponse(call: Call<mymovie?>, response: Response<mymovie?>) {
              val movieLo=response.body()?.results
                val res=findViewById<TextView>(R.id.txt1)
                res.text=movieLo.toString()
                Log.d("Hello",movieLo.toString())
            }

            override fun onFailure(call: Call<mymovie?>, t: Throwable) {
                Log.d("Hello","error in fetching movies")
            }
        })
    }
}
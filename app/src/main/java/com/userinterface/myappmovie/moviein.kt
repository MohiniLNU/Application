package com.userinterface.myappmovie

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val  base="https://api.themoviedb.org/3/"
interface moviein {
@GET("movie/popular")
    fun getmovies(@Query("api_key")api_key:String): Call<mymovie>
}

object movieService{
    val movieInst:moviein

    init{
        val retro= Retrofit.Builder().baseUrl(base).addConverterFactory(GsonConverterFactory.create()).build()
        movieInst=retro.create(moviein::class.java)

    }
}
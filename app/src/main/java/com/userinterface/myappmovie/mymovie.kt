package com.userinterface.myappmovie

data class mymovie(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)
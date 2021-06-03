package com.example.drawernavi.ui.News

import retrofit2.Call
import retrofit2.http.GET

interface CommentAPI {
    @GET("comment")
    fun getComments(): Call<List<Comment>>
}
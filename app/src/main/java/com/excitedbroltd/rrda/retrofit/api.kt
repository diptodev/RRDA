package com.excitedbroltd.rrda.retrofit

import androidx.lifecycle.LiveData
import com.excitedbroltd.rrda.datamodel.Posts
import retrofit2.Response
import retrofit2.http.GET

interface api {
    @GET("posts")
    suspend fun getAllData(): Response<List<Posts>>
}
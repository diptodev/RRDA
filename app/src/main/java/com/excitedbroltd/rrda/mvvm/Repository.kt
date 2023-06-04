package com.excitedbroltd.rrda.mvvm

import androidx.lifecycle.LiveData
import com.excitedbroltd.rrda.datamodel.Posts
import com.excitedbroltd.rrda.retrofit.api
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: api) {
    suspend fun getAllPosts(): Response<List<Posts>> {
        return api.getAllData()
    }
}
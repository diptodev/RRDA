package com.excitedbroltd.rrda.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.excitedbroltd.rrda.datamodel.Posts
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class MyViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    var myRetrofit = MutableLiveData<Response<List<Posts>>>()
    fun getAllData() {
        viewModelScope.launch {
            myRetrofit.value = repository.getAllPosts()
        }
    }

}
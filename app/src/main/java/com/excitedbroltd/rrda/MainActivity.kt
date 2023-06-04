package com.excitedbroltd.rrda

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.excitedbroltd.rrda.di.MyApplication
import com.excitedbroltd.rrda.mvvm.MyViewModel
import com.excitedbroltd.rrda.mvvm.MyViewModelFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"

    @Inject
    lateinit var myViewModelFactory: MyViewModelFactory


    private lateinit var myViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as MyApplication).myComponent.inject(this)
        myViewModel = ViewModelProvider(this, myViewModelFactory).get(MyViewModel::class.java)
        myViewModel.getAllData()
        myViewModel.myRetrofit.observe(this) { response ->
            if (response.isSuccessful) {
                response.body()?.forEach {
                    it.apply {
                        Log.d(TAG, "  id = $id")
                        Log.d(TAG, " user_id = $user_id")
                        Log.d(TAG, " title = $title")
                        Log.d(TAG, " body = $body")
                    }
                }
            } else {
                Log.d(TAG, "onCreate: failed")
            }

        }

    }
}


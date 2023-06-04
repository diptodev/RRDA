package com.excitedbroltd.rrda.di

import android.app.Application
import com.excitedbroltd.rrda.di.component.DaggerMyComponent
import com.excitedbroltd.rrda.di.component.MyComponent

class MyApplication : Application() {
    lateinit var myComponent: MyComponent
    override fun onCreate() {
        super.onCreate()
        myComponent = DaggerMyComponent.builder().build()
    }
}
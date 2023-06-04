package com.excitedbroltd.rrda.di.component

import com.excitedbroltd.rrda.MainActivity
import com.excitedbroltd.rrda.di.module.MyRetrofitModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MyRetrofitModule::class])
interface MyComponent {
    fun inject(mainActivity: MainActivity)
}
package com.excitedbroltd.rrda.di.module

import com.excitedbroltd.rrda.retrofit.Base_Url
import com.excitedbroltd.rrda.retrofit.api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MyRetrofitModule {
    @Provides
    @Singleton
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(Base_Url.base_url)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    fun getApi(retrofit: Retrofit): api {
        return retrofit.create(api::class.java)
    }
}
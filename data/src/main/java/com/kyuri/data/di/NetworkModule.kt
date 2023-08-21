package com.kyuri.data.di

import com.kyuri.data.network.ApiConfig
import com.kyuri.data.network.util.POKE_API_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideApiConfig(): ApiConfig {
        return Retrofit.Builder()
            .baseUrl(POKE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiConfig::class.java)
    }
}
package com.example.haroutine_android.api

import com.example.haroutine_android.repository.HyunMyeongRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val retrofit: Retrofit = Retrofit.Builder().apply {
    baseUrl("BASE_URL")
    addConverterFactory(GsonConverterFactory.create())
}.build()

val hyunMyeongApi: HyunMyeongApi by lazy {
    retrofit.create(HyunMyeongApi::class.java)
}
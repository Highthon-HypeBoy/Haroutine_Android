package com.example.haroutine_android.api

import com.example.haroutine_android.dto.response.seokgyu.CreateRoutineResponse
import com.example.haroutine_android.dto.response.seokgyu.GetRoutineResponse
import com.example.haroutine_android.util.ACCESS_TOKEN
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface SeokgyuApi {
    @POST("v1/routines")
    suspend fun createRoutine(

    ): CreateRoutineResponse

    @Headers("Authorization: Bearer $ACCESS_TOKEN")
    @GET("v1/routines")
    suspend fun getRoutineList(
    ): List<GetRoutineResponse>
}
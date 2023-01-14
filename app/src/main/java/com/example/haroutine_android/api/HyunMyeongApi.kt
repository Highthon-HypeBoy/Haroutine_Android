package com.example.haroutine_android.api

import com.example.haroutine_android.dto.response.hyunmyeong.RoutineDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HyunMyeongApi {

    @GET("/v1/routines/{id}")
    suspend fun fetchRoutineDetail(
        @Path("id") id: Int
    ): RoutineDetailResponse
}
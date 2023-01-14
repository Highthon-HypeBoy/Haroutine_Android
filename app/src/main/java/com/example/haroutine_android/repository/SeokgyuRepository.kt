package com.example.haroutine_android.repository

import com.example.haroutine_android.api.seokgyuApi
import com.example.haroutine_android.dto.response.seokgyu.CreateRoutineResponse
import com.example.haroutine_android.dto.response.seokgyu.GetRoutineResponse

class SeokgyuRepository {
    suspend fun createRoutine(): CreateRoutineResponse =
        seokgyuApi.createRoutine()

    suspend fun getRoutineList(): List<GetRoutineResponse> =
        seokgyuApi.getRoutineList()
}
package com.example.haroutine_android.ui.seokgyu.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.haroutine_android.R
import com.example.haroutine_android.databinding.ActivityMainBinding
import com.example.haroutine_android.dto.response.seokgyu.GetRoutineResponse
import com.example.haroutine_android.ui.BaseActivity
import com.example.haroutine_android.util.repeatOnStarted

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var routineAdapter: RoutineAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        repeatOnStarted {
            mainViewModel.eventFlow.collect { event -> handleEvent(event) }
        }
    }

    private fun handleEvent(event: MainViewModel.Event) {
        when(event) {
            is MainViewModel.Event.ErrorMessage -> {
                showShortToast(event.message)
            }
            is MainViewModel.Event.GetRoutineSuccess -> {
                initAdapter(event.getRoutineResponse)
            }
        }
    }

    private fun initAdapter(routines: List<GetRoutineResponse>) {
        routineAdapter = RoutineAdapter {
            startActivity(Intent(this, ))
        }
        routineAdapter.submitList(routines)
        binding.rvRoutine.adapter = routineAdapter
    }


    override fun initView() {
    }
}
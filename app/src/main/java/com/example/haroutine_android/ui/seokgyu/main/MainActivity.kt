package com.example.haroutine_android.ui.seokgyu.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.haroutine_android.R
import com.example.haroutine_android.databinding.ActivityMainBinding
import com.example.haroutine_android.ui.BaseActivity
import com.example.haroutine_android.ui.hyunmyeong.routinedetail.NonRoutineDetailActivity
import com.example.haroutine_android.ui.hyunmyeong.routinedetail.RoutineDetailActivity
import com.example.haroutine_android.ui.seokgyu.postcreate.RoutinePostActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var routineAdapter: RoutineAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.routine.setOnClickListener {
            val intent = Intent(this, RoutineDetailActivity::class.java)
            startActivity(intent)
        }
        binding.nonroutine.setOnClickListener {
            val intent = Intent(this, NonRoutineDetailActivity::class.java)
            startActivity(intent)
        }
        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, RoutinePostActivity::class.java))
        }
    }

    private fun handleEvent(event: MainViewModel.Event) {
        when(event) {
            is MainViewModel.Event.ErrorMessage -> {
                showShortToast(event.message)
            }
            is MainViewModel.Event.GetRoutineSuccess -> {
            }
        }
    }

    override fun initView() {
    }
}
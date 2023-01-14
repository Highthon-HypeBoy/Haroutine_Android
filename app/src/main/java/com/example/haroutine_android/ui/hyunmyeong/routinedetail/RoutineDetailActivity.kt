package com.example.haroutine_android.ui.hyunmyeong.routinedetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.haroutine_android.R
import com.example.haroutine_android.databinding.ActivityRoutineDetailBinding
import com.example.haroutine_android.ui.BaseActivity
import com.example.haroutine_android.util.repeatOnStarted

class RoutineDetailActivity : BaseActivity<ActivityRoutineDetailBinding>(
    R.layout.activity_routine_detail
){
    private val remoteDetailViewModel: RemoteDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_routine_detail)

        repeatOnStarted {
            remoteDetailViewModel.eventFlow.collect { event -> handleEvent(event) }
        }
    }

    private fun handleEvent(event: RemoteDetailViewModel.Event) {
        when(event) {
            is RemoteDetailViewModel.Event.ErrorMessage -> {
                showShortToast(event.message)
            }
            is RemoteDetailViewModel.Event.FetchDetailSuccess -> {
                event.routineDetailResponse
            }
        }
    }


    override fun initView() {
        TODO("Not yet implemented")
    }
}
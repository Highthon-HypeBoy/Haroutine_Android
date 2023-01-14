package com.example.haroutine_android.util

import android.widget.TextView
import androidx.databinding.BindingAdapter


object BindingAdapter {
    @JvmStatic
    @BindingAdapter("tags")
    fun setTags(view: TextView, tags: List<String>) {
        tags.forEach {
            print("#$it  ")
        }
    }
}
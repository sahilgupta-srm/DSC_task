package com.example.weather_final.data.model


import android.widget.ImageView
import androidx.databinding.BindingAdapter

import com.google.gson.annotations.SerializedName


data class Weather(
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val main: String
)

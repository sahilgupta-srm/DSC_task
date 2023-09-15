package com.example.weather_final.domain.util

import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import com.example.weather_final.R


import com.squareup.picasso.Picasso
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

object WeatherConversionsUtil {

    @RequiresApi(Build.VERSION_CODES.O)
    @JvmStatic
    fun changeDateFormat(value: Int): String {
        try {
            val formatter = DateTimeFormatter
                .ofPattern("h:mm a", Locale.ENGLISH)
                .withZone(ZoneId.of("Asia/Kathmandu"))
            return formatter.format(Instant.ofEpochSecond(value.toLong()))
        } catch (e: Exception) {
            return e.toString()
        }
    }





    @JvmStatic
    @BindingAdapter(value = ["src", "placeholderImage"], requireAll = false)
    fun loadImage(imageView: ImageView, src: String?, placeholderImage: Drawable?) {
        val posterURL = "https://openweathermap.org/img/wn/"+src+ "@2x.png"
        if (placeholderImage != null) {
            Picasso.get().load(posterURL).into(imageView)
        } else {
            Picasso.get().load(posterURL).into(imageView)
        }
    }

    @JvmStatic
    @BindingAdapter("app:imageurl")
    fun loadImageback(imageView: ImageView, desc: String?) {
        when(desc){
            "Rain" -> Picasso.get().load(R.drawable.card_rain).fit().into(imageView);
            "Thunderstorm" ->Picasso.get().load(R.drawable.card_thunderstorm).fit().into(imageView);
            "Drizzle" -> Picasso.get().load(R.drawable.card_drizzle).fit().into(imageView);
            "Snow" -> Picasso.get().load(R.drawable.card_snow).fit().into(imageView);
            "Clear" -> Picasso.get().load(R.drawable.card_clear).fit().into(imageView);
            "Clouds" -> Picasso.get().load(R.drawable.card_clouds).fit().into(imageView);
            else -> Picasso.get().load(R.drawable.card_atmos).fit().into(imageView);
        }
    }

    @JvmStatic
    @BindingAdapter("android:visibility")
    fun setVisibility(view: View, value: Boolean) {
        view.setVisibility(if (value) View.VISIBLE else View.GONE)
    }

}
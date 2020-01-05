package com.example.android.databinding.basicsample.util

import android.content.res.ColorStateList
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter
import com.example.android.databinding.basicsample.R
import com.example.android.databinding.basicsample.data.Popularity

/**
 * Created by Dmitry Torin on 2020-01-05.
 * mova.io
 * Slack: @dt
 */

@BindingAdapter("app:progressColorByPopularity")
fun progressColor(iv: ImageView, popularity: Popularity) {
    val color = when (popularity) {
        Popularity.NORMAL -> iv.context.theme.obtainStyledAttributes(
                intArrayOf(android.R.attr.colorForeground)
        ).getColor(0, 0x000000)
        Popularity.POPULAR -> ContextCompat.getColor(iv.context, R.color.popular)
        Popularity.STAR -> ContextCompat.getColor(iv.context, R.color.star)
    }

    ImageViewCompat.setImageTintList(iv, ColorStateList.valueOf(color))
}

@BindingAdapter("app:iconByPopularity")
fun iconByPopularity(iv: ImageView, popularity: Popularity) {
    val icon = when (popularity) {
        Popularity.NORMAL -> {
            ContextCompat.getDrawable(iv.context, R.drawable.ic_person_black_96dp)
        }
        Popularity.POPULAR -> {
            ContextCompat.getDrawable(iv.context, R.drawable.ic_whatshot_black_96dp)
        }
        Popularity.STAR -> {
            ContextCompat.getDrawable(iv.context, R.drawable.ic_whatshot_black_96dp)
        }
    }
    iv.setImageDrawable(icon)
}
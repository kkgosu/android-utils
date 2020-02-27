package com.example.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.target.Target

fun Context.showToast(text: String?, duration: Int = Toast.LENGTH_SHORT) {
    text?.let { Toast.makeText(this, it, duration).show() }
}

fun ImageView.loadImage(image: String?) = ifNotDestroyed {
    Glide.with(this).load(image).centerCrop().into(this)
}

fun ImageView.loadImage2(image: String?) = ifNotDestroyed {
    image?.let {
        Glide.with(this)
            .load(it)
            .transition(DrawableTransitionOptions.withCrossFade(375))
            .override(Target.SIZE_ORIGINAL)
            .centerCrop()
            .into(this)
    }
}

fun ImageView.loadPhotoOrFallback(photoUrl: String?) = ifNotDestroyed {
    Glide.with(this).load(photoUrl).fallback(R.drawable.ic_launcher_foreground).into(this)
}

private fun View.ifNotDestroyed(block: () -> Unit) {
    if (!(context as Activity).isDestroyed) {
        block()
    }
}

fun RecyclerView.setDivider(@DrawableRes drawableRes: Int) {
    val divider = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
    val drawable = ContextCompat.getDrawable(this.context, drawableRes)
    drawable?.let {
        divider.setDrawable(it)
        addItemDecoration(divider)
    }
}

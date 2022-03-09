package com.anddev404.repository.remote.image_loaders

import android.content.Context
import android.widget.ImageView

interface ImageLoaderInterface {

    fun loadImage(imageView: ImageView, url: String, context: Context)
}
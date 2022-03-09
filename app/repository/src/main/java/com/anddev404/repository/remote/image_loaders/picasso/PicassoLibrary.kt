package com.anddev404.repository.remote.image_loaders.picasso

import android.content.Context
import android.widget.ImageView
import com.anddev404.repository.remote.image_loaders.ImageLoaderInterface
import com.squareup.picasso.Picasso

class PicassoLibrary : ImageLoaderInterface {

    override fun loadImage(imageView: ImageView, url: String, context: Context) {

        if (url.length > 0) {
            Picasso.with(context)
                .load(url)
                .into(imageView)
        }
    }
}
package com.example.android.booksapi

import android.graphics.Bitmap

/**
 * Created by lenovo on 6/28/2017.
 */

data class News(
        val author:kotlin.String,
        val title:kotlin.String,
        val description:kotlin.String,
        val url:kotlin.String,
        val urlToImage:kotlin.String,
        val publishedAt:kotlin.String,
        val bitmap: Bitmap

)

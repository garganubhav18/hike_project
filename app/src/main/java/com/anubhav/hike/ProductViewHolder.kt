package com.anubhav.hike

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anubhav.hike.model.Photo
import com.bumptech.glide.Glide

class ProductViewHolder(view: View, private val context: Context) : RecyclerView.ViewHolder(view) {

    private val imageIv = view.findViewById<ImageView>(R.id.productIv)
    private val countTv = view.findViewById<TextView>(R.id.count_tv)

    fun setImage(photo: Photo, position: Int) {
        countTv.text = position.toString()
        val url = "https://live.staticflickr.com/${photo.getServer()}/${photo.getId()}_${photo.getSecret()}.jpg"
        Glide.with(context).load(url).placeholder(R.drawable.ic_launcher_background).into(imageIv)
    }
}
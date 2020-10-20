package com.anubhav.hike.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SearchResponse {

    @SerializedName("photos")
    @Expose
    private var photos: Photos? = null

    @SerializedName("stat")
    @Expose
    private var stat: String? = null

    fun getPhotos(): Photos? {
        return photos
    }

    fun setPhotos(photos: Photos?) {
        this.photos = photos
    }

    fun getStat(): String? {
        return stat
    }

    fun setStat(stat: String?) {
        this.stat = stat
    }

}
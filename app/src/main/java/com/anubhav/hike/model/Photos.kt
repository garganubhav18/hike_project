package com.anubhav.hike.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Photos {
    @SerializedName("page")
    @Expose
    private var page: Int = 0

    @SerializedName("pages")
    @Expose
    private var pages: Int = 0

    @SerializedName("perpage")
    @Expose
    private var perpage: Int = 0

    @SerializedName("total")
    @Expose
    private var total: String? = null

    @SerializedName("photo")
    @Expose
    private var photo: MutableList<Photo>? = null

    fun getPage(): Int {
        return page
    }

    fun setPage(page: Int) {
        this.page = page
    }

    fun getPages(): Int {
        return pages
    }

    fun setPages(pages: Int) {
        this.pages = pages
    }

    fun getPerpage(): Int {
        return perpage
    }

    fun setPerpage(perpage: Int) {
        this.perpage = perpage
    }

    fun getTotal(): String? {
        return total
    }

    fun setTotal(total: String?) {
        this.total = total
    }

    fun getPhoto(): MutableList<Photo>? {
        return photo
    }

    fun setPhoto(photo: MutableList<Photo>?) {
        this.photo = photo
    }
}
package com.anubhav.hike.network.repository

import com.anubhav.hike.model.SearchResponse
import com.anubhav.hike.network.ApiClient
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchRepo {

    private val searchApi = ApiClient.apiClient!!.getSearchApi()

    fun searchImages(text: String, page:String): Single<SearchResponse?> {
        val url = "https://api.flickr.com/services/rest"
        return searchApi.getRepositories(url, "flickr.photos.search", "3e7cc266ae2b0e0d78e279ce8e361736", "json", "1", text, page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { response ->
                val searchResponse = response.body()
                if(response.isSuccessful && searchResponse != null) {
                    searchResponse
                } else {
                    null
                }
            }
            .onErrorReturn { null }

    }
}
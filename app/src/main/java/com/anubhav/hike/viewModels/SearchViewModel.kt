package com.anubhav.hike.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anubhav.hike.model.Photo
import com.anubhav.hike.model.SearchResponse
import com.anubhav.hike.network.repository.SearchRepo
import io.reactivex.disposables.CompositeDisposable

class SearchViewModel: ViewModel() {
    private val searchRepo = SearchRepo()
    private val compositeDisposable = CompositeDisposable()

    val searchObservable = MutableLiveData<SearchResponse?>()
    var currentPage: Int = 0
    var totalPage:Int = 1
    val model =  ArrayList<Photo>()

    var searchText: String = ""

    var isLoading = false

    fun getSearchList(text: String, page: Int) {
        searchText = text
        isLoading = true
        compositeDisposable.add(searchRepo.searchImages(text, page.toString()).subscribe({
            isLoading = false
            if(it != null) {
                updateModel(it)
            }
            searchObservable.value = it
        }, {
            isLoading = false
            searchObservable.value = null
        }))
    }

    private fun updateModel(searchResponse: SearchResponse) {
        if(!searchResponse.getPhotos()?.getPhoto().isNullOrEmpty()) {
            if(searchResponse.getPhotos()!!.getPage() == 1) {
                model.clear()
            }
            model.addAll(searchResponse.getPhotos()!!.getPhoto()!!)
            currentPage = searchResponse.getPhotos()!!.getPage()
            totalPage = searchResponse.getPhotos()!!.getPages()
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}
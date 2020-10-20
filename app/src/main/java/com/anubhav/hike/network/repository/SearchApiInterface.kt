package com.anubhav.hike.network.repository

import com.anubhav.hike.model.SearchResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface SearchApiInterface {

    @GET
    fun getRepositories(@Url url: String,
                        @Query("method") method: String?,
                        @Query("api_key") apiKey: String?,
                        @Query("format") format: String?,
                        @Query("nojsoncallback") jsonCallback: String?,
                        @Query("text") text: String?,
                        @Query("page") page:String?): Single<Response<SearchResponse?>>
}
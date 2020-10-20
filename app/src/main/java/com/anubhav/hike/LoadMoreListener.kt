package com.anubhav.hike

interface LoadMoreListener {

    fun loadMore()

    fun shouldAddLoadMore() : Boolean
}
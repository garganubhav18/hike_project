package com.anubhav.hike

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anubhav.hike.model.SearchResponse
import com.anubhav.hike.viewModels.SearchViewModel

class SearchFragment: Fragment(), LoadMoreListener {

    private var searchViewModel: SearchViewModel? = null
    private var searchEt: EditText? = null
    private var recyclerView: RecyclerView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_fragment_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservable()
        searchEt = view.findViewById(R.id.search_et)

        searchEt?.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            var keyCode = 0
            if (event != null) keyCode = event.keyCode
            if (actionId == EditorInfo.IME_ACTION_SEARCH || keyCode == KeyEvent.KEYCODE_ENTER) {
                searchEt?.clearFocus()
                hideSoftInput()
                startSearch(searchEt?.text?.toString()?:"")
                return@OnEditorActionListener true
            }
            false
        })

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView?.layoutManager = LinearLayoutManager(context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }

    private fun startSearch(text: String) {
        recyclerView?.visibility = View.GONE
        searchViewModel!!.getSearchList(text, 1)
    }

    private fun initObservable() {
        searchViewModel?.searchObservable?.observe(this, Observer { searchResponse: SearchResponse? ->
            if(searchResponse != null) {
                recyclerView?.visibility = View.VISIBLE
                if(recyclerView?.adapter == null) {
                    recyclerView?.adapter = SearchAdapter(searchViewModel!!.model, this)
                } else {
                    if(recyclerView?.adapter is SearchAdapter) {
                        (recyclerView?.adapter as SearchAdapter).setPhotos(searchViewModel!!.model)
                    }
                }
            }
        })
    }

    override fun loadMore() {
        if(!searchViewModel!!.isLoading) {
            searchViewModel!!.getSearchList(searchViewModel!!.searchText, searchViewModel!!.currentPage + 1)
        }
    }

    override fun shouldAddLoadMore(): Boolean {
        return searchViewModel!!.currentPage < searchViewModel!!.totalPage
    }

    private fun hideSoftInput() {
        if (activity == null || requireActivity().isFinishing) {
            return
        }
        try {
            val imm = requireActivity().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(requireActivity().window.decorView.windowToken, 0)
        } catch (e: Exception) {

        }
    }
}
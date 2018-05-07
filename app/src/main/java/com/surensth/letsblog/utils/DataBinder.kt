package com.surensth.letsblog.utils

/**
 * Created by surensth on 5/6/18.
 */

import android.databinding.BindingAdapter
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import com.surensth.letsblog.adapter.FixtureAdapter

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: FixtureAdapter) {
    view.adapter = adapter
}

@BindingAdapter("layoutManager")
fun setLayoutManager(view: RecyclerView, layoutManager: RecyclerView.LayoutManager) {
    view.layoutManager = layoutManager
}

@BindingAdapter("dividerItemDecoration")
fun setDividerItemDecoration(view: RecyclerView, dividerItemDecoration: DividerItemDecoration) {
    view.addItemDecoration(dividerItemDecoration)
}
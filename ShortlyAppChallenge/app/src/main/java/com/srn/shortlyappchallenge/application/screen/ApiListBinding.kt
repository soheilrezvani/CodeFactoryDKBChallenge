package com.srn.shortlyappchallenge.application.screen

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.srn.shortlyappchallenge.application.screen.adapter.ApiListAdapter
import com.srn.shortlyappchallenge.domain.model.Api

/**
 * Created by SoheilR .
 */
@BindingAdapter("app:items")
fun setItems(listView: RecyclerView , items: List<Api>?) {
    items?.let {
        (listView.adapter as ApiListAdapter).submitList(items)
    }
}
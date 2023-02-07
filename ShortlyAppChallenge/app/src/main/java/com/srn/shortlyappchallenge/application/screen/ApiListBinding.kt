package com.srn.shortlyappchallenge.application.screen

import android.content.Context
import androidx.appcompat.widget.AppCompatButton
import androidx.compose.ui.res.stringResource
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.srn.shortlyappchallenge.application.screen.adapter.ApiListAdapter
import com.srn.shortlyappchallenge.domain.model.ApiResult
import com.srn.shortlyappchallenge.R


/**
 * Created by SoheilR .
 */
@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<ApiResult>?) {
    items?.let {
        (listView.adapter as ApiListAdapter).submitList(items)
    }
}

@BindingAdapter("app:copyStatus")
fun setStyle(button: AppCompatButton, isCopied: Boolean) {
    if (isCopied) {
        button.setBackgroundResource(R.drawable.rounded_copied_button)
        button.text = "Copied"
    }else {
        button.setBackgroundResource(R.drawable.rounded_copy_button)
        button.text = "Copy"
    }
}
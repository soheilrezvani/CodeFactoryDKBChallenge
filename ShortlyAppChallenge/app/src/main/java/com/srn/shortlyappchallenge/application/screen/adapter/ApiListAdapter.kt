package com.srn.shortlyappchallenge.application.screen.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.srn.shortlyappchallenge.application.screen.ApiListViewModel
import com.srn.shortlyappchallenge.application.screen.adapter.ItemTypes.*
import com.srn.shortlyappchallenge.databinding.ItemEmptyListLayoutBinding
import com.srn.shortlyappchallenge.databinding.ItemHeaderLayoutBinding
import com.srn.shortlyappchallenge.databinding.ItemLayoutBinding
import com.srn.shortlyappchallenge.domain.model.ApiResult

/**
 * Created by SoheilR .
 */
class ApiListAdapter(private val viewModel: ApiListViewModel) :
    ListAdapter<ApiResult, RecyclerView.ViewHolder>(DiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (ItemTypes.values()[viewType]) {
            EMPTY_LIST -> EmptyListViewHolder.from(parent)
            HEADER -> HeaderViewHolder.from(parent)
            ITEMS -> ListItemsViewHolder.from(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ListItemsViewHolder -> {
                holder.bind(viewModel, currentList[position - 1])
            }
            is HeaderViewHolder -> holder.bindHeader()
            is EmptyListViewHolder -> holder.bindEmptyList()

        }
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            itemCount == 1 -> EMPTY_LIST.ordinal
            (position == 0) -> HEADER.ordinal
            else -> ITEMS.ordinal
        }
    }

    override fun getItemCount(): Int {
        return currentList.size + 1
    }

    class HeaderViewHolder private constructor(private val binding: ItemHeaderLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindHeader() {
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): HeaderViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemHeaderLayoutBinding.inflate(layoutInflater, parent, false)

                return HeaderViewHolder(binding)
            }
        }
    }

    class EmptyListViewHolder private constructor(private val binding: ItemEmptyListLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindEmptyList() {
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): EmptyListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemEmptyListLayoutBinding.inflate(layoutInflater, parent, false)

                return EmptyListViewHolder(binding)
            }
        }
    }

    class ListItemsViewHolder private constructor(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: ApiListViewModel, item: ApiResult) {
            binding.viewModel = viewModel
            binding.item = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ListItemsViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemLayoutBinding.inflate(layoutInflater, parent, false)

                return ListItemsViewHolder(binding)
            }
        }
    }

}

/**
 * Callback for calculating the diff between two non-null items in a list.
 *
 * Used by ListAdapter to calculate the minimum number of changes between and old list and a new
 * list that's been passed to `submitList`.
 */
class DiffCallback : DiffUtil.ItemCallback<ApiResult>() {
    override fun areItemsTheSame(oldItem: ApiResult, newItem: ApiResult) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: ApiResult,
        newItem: ApiResult,
    ) = oldItem == newItem
}
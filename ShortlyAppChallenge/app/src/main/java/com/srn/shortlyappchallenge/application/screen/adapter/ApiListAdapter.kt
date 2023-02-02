package com.srn.shortlyappchallenge.application.screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.srn.shortlyappchallenge.application.screen.ApiListViewModel
import com.srn.shortlyappchallenge.databinding.ItemLayoutBinding
import com.srn.shortlyappchallenge.domain.model.Api

/**
 * Created by SoheilR .
 */
class ApiListAdapter (private val viewModel: ApiListViewModel) :
    ListAdapter<Api, RecyclerView.ViewHolder>(DiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return  NormalViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
            if (holder is NormalViewHolder) {
            holder.bind(viewModel, item)
        }
    }


    class NormalViewHolder private constructor(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: ApiListViewModel, item: Api) {
            binding.viewModel = viewModel
            binding.item = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): NormalViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemLayoutBinding.inflate(layoutInflater, parent, false)

                return NormalViewHolder(binding)
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
class DiffCallback : DiffUtil.ItemCallback<Api>() {
    override fun areItemsTheSame(oldItem: Api, newItem: Api): Boolean {
        return oldItem.result.code == newItem.result.code
    }

    override fun areContentsTheSame(
        oldItem: Api,
        newItem: Api,
    ): Boolean {
        return oldItem == newItem
    }
}
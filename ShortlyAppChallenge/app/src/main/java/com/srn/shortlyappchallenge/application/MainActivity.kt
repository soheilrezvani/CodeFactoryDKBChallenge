package com.srn.shortlyappchallenge.application

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.srn.shortlyappchallenge.R
import com.srn.shortlyappchallenge.application.screen.ApiListViewModel
import com.srn.shortlyappchallenge.application.screen.adapter.ApiListAdapter
import com.srn.shortlyappchallenge.application.util.copyToClipboard
import com.srn.shortlyappchallenge.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: ApiListViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: ApiListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservers()
        setupViews()
        viewModel.getApiListFromDB()
    }

    private fun setupViews() {
        binding.shortenUrlBtn.setOnClickListener {
            val input = binding.inputUrlEt.text
            if (!input.isNullOrEmpty()) {
                viewModel.getShortenApi(input.toString())
            }
            updateUi(input.isNullOrEmpty())
        }
        setupAdapter()
    }

    private fun updateUi(isEmpty: Boolean) = if (isEmpty) {
        binding.inputUrlEt.hint = getString(R.string.error_input_url_text)
        binding.inputUrlEt.setHintTextColor(ContextCompat.getColor(this,
            R.color.error_input_text_color))
    } else {
        binding.inputUrlEt.hint = getString(R.string.hint_input_url_text)
        binding.inputUrlEt.setHintTextColor(ContextCompat.getColor(this,
            R.color.hint_input_text_color))
        binding.inputUrlEt.text?.clear()
    }

    private fun setupAdapter() {
        adapter = ApiListAdapter(viewModel)
        binding.apiListRV.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.apiListRV.setHasFixedSize(true)
        binding.apiListRV.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getLoadingToastEvent().observe(this) {
            showToast("Loading")
        }
        viewModel.getErrorToastEvent().observe(this) {
            it?.let { it1 -> showToast(it1) }
        }
        viewModel.savedApiList.observe(this) {
            adapter.submitList(it)
            binding.apiListRV.scrollToPosition(it.size)
            updateUi(false)
        }
        viewModel.deleteApiEvent.observe(this) {
            showToast("Task is deleted")
        }
        viewModel.copyClipBoardLiveEvent.observe(this) {
            copyIntoClipboard(it)
        }
        viewModel.saveApiEvent.observe(this) {
            showToast("saved in DB successfully")
        }
    }

    private fun copyIntoClipboard(it: String?) {
        it?.let { it1 -> this@MainActivity.copyToClipboard(it1) }
        showToast("Copied into Clipboard")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
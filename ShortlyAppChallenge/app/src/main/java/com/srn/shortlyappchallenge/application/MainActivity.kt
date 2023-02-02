package com.srn.shortlyappchallenge.application

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.srn.shortlyappchallenge.application.screen.ApiListViewModel
import com.srn.shortlyappchallenge.application.screen.adapter.ApiListAdapter
import com.srn.shortlyappchallenge.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: ApiListViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: ApiListAdapter
    val sampleUrl = "example.org/very/long/link.html"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservers()
        viewModel.getShortenApi(sampleUrl)
        setupViews()
    }

    private fun setupViews() {
        binding.shortenUrlBtn.setOnClickListener {
            val input = binding.inputUrlEt.text
            if (!input.isNullOrEmpty()) {
                viewModel.getShortenApi(input.toString())
            }else {
                binding.inputUrlEt.error = "Please add a link here"
            }
        }
        adapter = ApiListAdapter(viewModel)
        binding.apiListRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)
        binding.apiListRV.adapter = adapter
        binding.apiListRV.setHasFixedSize(true)
    }

    private fun setupObservers() {
        viewModel.getLoadingToastEvent().observe(this) {
            showToast("Loading")
        }
        viewModel.getErrorToastEvent().observe(this) {
            it?.let { it1 -> showToast(it1) }
        }
        viewModel.resultListLiveData.observe(this) {
            Log.d("SSS", "result of the Api : ${it.toString()}")
            adapter.submitList(it)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
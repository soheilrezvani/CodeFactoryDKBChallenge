package com.srn.shortlyappchallenge.application

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.srn.shortlyappchallenge.application.screen.ApiListViewModel
import com.srn.shortlyappchallenge.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: ApiListViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
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
            viewModel.getShortenApi(sampleUrl)
        }
    }

    private fun setupObservers() {
        viewModel.getLoadingToastEvent().observe(this) {
            showToast("Loading")
        }
        viewModel.getErrorToastEvent().observe(this) {
            it?.let { it1 -> showToast(it1) }
        }
        viewModel.shortenedUrl.observe(this) {
            Log.d("SSS", "result of the Api : ${it.toString()}")
        }
    }

    private fun showToast(message: String) {
        binding.textView.text = message
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
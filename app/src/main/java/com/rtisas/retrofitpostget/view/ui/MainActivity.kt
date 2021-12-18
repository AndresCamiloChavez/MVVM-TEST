package com.rtisas.retrofitpostget.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.rtisas.retrofitpostget.databinding.ActivityMainBinding
import com.rtisas.retrofitpostget.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel : QuoteViewModel by  viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()
        quoteViewModel.quoteData.observe(this, Observer {
            binding.tvQuote.text = it.quote
            binding.tvAuthor.text = it.author
        })
        quoteViewModel.isLoading.observe(this, Observer { active ->
            binding.progress.isVisible = active
        })
        binding.parentContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }


    }
}
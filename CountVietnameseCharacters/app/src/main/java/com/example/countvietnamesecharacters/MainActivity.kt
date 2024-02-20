package com.example.countvietnamesecharacters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.countvietnamesecharacters.databinding.ActivityMainBinding

interface ClickHandler {
    fun onClick()
}

class MainActivity : AppCompatActivity(), ClickHandler {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = MainViewModel()
        binding.viewModel = viewModel
        binding.clickHandler = this
        binding.lifecycleOwner = this
    }

    override fun onClick() {

        viewModel.isButtonClicked.value = true
        viewModel.countVietnameseCharacters(binding.editText.text.toString())

    }
}
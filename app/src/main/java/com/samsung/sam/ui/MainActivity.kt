package com.samsung.sam.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.samsung.sam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var counter=0

    val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        viewModel.userData.observe(this,{

            binding.textViewData.setText(it.toString())
        })

        viewModel.message.observe(this){


        }


        binding.textViewCounter.setText("${viewModel.getCounter()}")


        binding.button.setOnClickListener {

            viewModel.increment()

            binding.textViewCounter.setText("${viewModel.getCounter()}")

        }


        binding.buttonGetData.setOnClickListener {

            viewModel.getData()
        }


    }
}
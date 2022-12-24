package com.samsung.sam.ui.adduser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.samsung.sam.R
import com.samsung.sam.data.model.User
import com.samsung.sam.databinding.ActivityAddUserBinding
import com.samsung.sam.databinding.ActivityMainBinding

class AddUserActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddUserBinding

    val viewModel: AddUserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityAddUserBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        viewModel.userAdded.observe(this){

            Toast.makeText(this, "User has been created successfully with id ${it.id}", Toast.LENGTH_SHORT).show()


        }

        binding.buttonAdduser.setOnClickListener {

            viewModel.addUser(User(binding.textInputName.text.toString(),binding.textInputPhone.text.toString()))
        }



    }
}
package com.app.todoapp.presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.todoapp.databinding.ActivityMainBinding
import com.app.todoapp.presentation.create.CreateUserActivity
import com.app.todoapp.presentation.SecondActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {

            startActivity(Intent(this, SecondActivity::class.java))
            finish()
        }

        binding.createBtn.setOnClickListener {
            startActivity(Intent(this, CreateUserActivity::class.java))
        }

    }

}
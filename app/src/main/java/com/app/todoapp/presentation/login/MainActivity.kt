package com.app.todoapp.presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.app.todoapp.databinding.ActivityMainBinding
import com.app.todoapp.presentation.create.CreateUserActivity
import com.example.todoapp.SecondActivity
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
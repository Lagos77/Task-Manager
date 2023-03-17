package com.app.todoapp.presentation.create

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.todoapp.databinding.ActivityCreateUserBinding
import com.app.todoapp.presentation.login.MainActivity
import com.app.todoapp.util.Utils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createBtn.setOnClickListener {
            Utils.confirmationAlert(this,"Success","Your account has been created", DialogInterface.OnClickListener { dialogInterface, i ->
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            })
        }

        binding.cancelBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
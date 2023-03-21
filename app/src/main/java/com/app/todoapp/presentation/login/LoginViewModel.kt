package com.app.todoapp.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.firebaseAuth.FirebaseAuthRepository
import com.example.domain.entity.firebaseAuth.FirebaseAuthUseCase
//import com.example.domain.entity.firebaseAuth.FirebaseAuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val firebaseAuthUseCase: FirebaseAuthUseCase) : ViewModel() {

    fun createUser(email: String, password: String, password2: String) {
        viewModelScope.launch {
            firebaseAuthUseCase.createAuth(email, password, password2)
        }
    }
}
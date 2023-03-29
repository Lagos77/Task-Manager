package com.example.domain.firebaseAuth

import javax.inject.Inject

class FirebaseAuthUseCase @Inject constructor(private val firebaseAuthRepository: FirebaseAuthRepository) {

    suspend fun createAuth(email: String, password: String, password2: String) {
        return firebaseAuthRepository.createAuth(email,password, password2)
    }
}
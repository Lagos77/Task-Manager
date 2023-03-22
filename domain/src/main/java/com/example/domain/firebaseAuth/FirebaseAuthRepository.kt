package com.example.domain.firebaseAuth

interface FirebaseAuthRepository {

    suspend fun loginAuth(email: String, password: String)

    suspend fun createAuth(email: String, password: String, password2: String)

}
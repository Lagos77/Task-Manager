package com.example.data.firebaseAuth

import android.util.Log
import com.example.domain.firebaseAuth.FirebaseAuthRepository
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class FirebaseAuthRepositoryImp @Inject constructor(private val firebaseAuth: FirebaseAuth) :
    FirebaseAuthRepository {

    override suspend fun loginAuth(email: String, password: String) {
        if (email.isNullOrBlank() || password.isNullOrBlank()) {
            Log.d("alexander", "its empty, check again")
        } else {
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Do something
                    }
                }
        }

    }

    override suspend fun createAuth(email: String, password: String, password2: String) {
        if (email.isNullOrBlank() || password.isNullOrBlank()) {
            Log.d("alexander", "its empty to create this")
            if (password != password2) {
                Log.d("alexander", "password doesn't match")
            }
        } else {
            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    //Do something
                }
            }
        }

    }

}
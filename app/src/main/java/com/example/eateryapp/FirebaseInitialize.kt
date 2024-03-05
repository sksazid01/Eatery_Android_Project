package com.example.eateryapp

import android.app.Application
import com.google.firebase.FirebaseApp

class FirebaseInitialize : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}
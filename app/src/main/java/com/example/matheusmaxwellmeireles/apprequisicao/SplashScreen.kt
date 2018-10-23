package com.example.matheusmaxwellmeireles.apprequisicao

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import java.util.*
import kotlin.concurrent.schedule

class SplashScreen : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val intent = Intent(this, MainActivity::class.java)

        Timer().schedule(1500){
            startActivity(intent)
        }
    }
}

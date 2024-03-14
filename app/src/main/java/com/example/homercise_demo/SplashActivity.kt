package com.example.homercise_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.logging.Handler

class SplashActivity : AppCompatActivity() {

        private val SPLASH_DELAY: Long = 1500
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_splash)

            android.os.Handler().postDelayed({
                val mainIntent = Intent(this, Login::class.java)
                startActivity(mainIntent)
                finish()
            }, SPLASH_DELAY)
        }
}
package com.example.homercise_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.util.logging.Handler

class SplashActivity : AppCompatActivity() {

        private val SPLASH_DELAY: Long = 2000
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_splash)

            val imageView: ImageView = findViewById(R.id.loadrunning)
            Glide.with(this)
                .asGif()
                .load(R.drawable.animation)
                .into(imageView)
//            imageView.setImageResource(R.drawable.loading)

            android.os.Handler().postDelayed({
                val mainIntent = Intent(this, Login::class.java)
                startActivity(mainIntent)
                finish()
            }, SPLASH_DELAY)
        }
}
package com.example.homercise_demo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import com.example.homercise_demo.databinding.ActivityFullBodyBurpeesBinding
import com.example.homercise_demo.databinding.ActivityFullBodyKneePushupBinding

class FullBodyKneePushup : AppCompatActivity() {

    private lateinit var binding: ActivityFullBodyKneePushupBinding
    private lateinit var videoViewKneePushup: VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullBodyKneePushupBinding.inflate(layoutInflater)
        setContentView(binding.root)


        videoViewKneePushup = findViewById(R.id.video1)

        val videoUri1 = Uri.parse("android.resource://" + packageName + "/" + R.raw.knee_pushups)

        videoViewKneePushup.setVideoURI(videoUri1)

        videoViewKneePushup.start()

        videoViewKneePushup.setOnCompletionListener { mp ->
            mp.start()



            binding.imageButton5.setOnClickListener {
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
            }

            binding.imageButton6.setOnClickListener {
                val intent = Intent(this, Exercise::class.java)
                startActivity(intent)
            }

            binding.imageButton7.setOnClickListener {
                val intent = Intent(this, Setting::class.java)
                startActivity(intent)
            }

            binding.imageButton8.setOnClickListener {
                val intent = Intent(this, Profile::class.java)
                startActivity(intent)

            }
        }
    }
}
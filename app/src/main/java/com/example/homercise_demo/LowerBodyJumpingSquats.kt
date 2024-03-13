package com.example.homercise_demo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import com.example.homercise_demo.databinding.ActivityLowerBodyDonkeyKickBinding
import com.example.homercise_demo.databinding.ActivityLowerBodyJumpingSquatsBinding

class LowerBodyJumpingSquats : AppCompatActivity() {

    private lateinit var binding: ActivityLowerBodyJumpingSquatsBinding
    private lateinit var videoViewJumpingSquats: VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLowerBodyJumpingSquatsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        videoViewJumpingSquats = findViewById(R.id.video1)

        val videoUri1 = Uri.parse("android.resource://" + packageName + "/" + R.raw.jumping_squats)

        videoViewJumpingSquats.setVideoURI(videoUri1)

        videoViewJumpingSquats.start()

        videoViewJumpingSquats.setOnCompletionListener { mp ->
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
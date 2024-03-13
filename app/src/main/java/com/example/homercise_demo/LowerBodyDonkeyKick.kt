package com.example.homercise_demo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import com.example.homercise_demo.databinding.ActivityLowerBodyBackLungeBinding
import com.example.homercise_demo.databinding.ActivityLowerBodyDonkeyKickBinding

class LowerBodyDonkeyKick : AppCompatActivity() {

    private lateinit var binding: ActivityLowerBodyDonkeyKickBinding
    private lateinit var videoViewDonkeyKick: VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLowerBodyDonkeyKickBinding.inflate(layoutInflater)
        setContentView(binding.root)


        videoViewDonkeyKick = findViewById(R.id.video1)

        val videoUri1 = Uri.parse("android.resource://" + packageName + "/" + R.raw.donkey_kick)

        videoViewDonkeyKick.setVideoURI(videoUri1)

        videoViewDonkeyKick.start()

        videoViewDonkeyKick.setOnCompletionListener { mp ->
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
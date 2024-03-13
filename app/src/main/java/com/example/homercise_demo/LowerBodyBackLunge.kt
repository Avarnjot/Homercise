package com.example.homercise_demo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import com.example.homercise_demo.databinding.ActivityLowerBodyBackLungeBinding
import com.example.homercise_demo.databinding.ActivityLowerBodySideLegBinding
import com.example.homercise_demo.databinding.ActivityLowerBodySquatsBinding

class LowerBodyBackLunge : AppCompatActivity() {

    private lateinit var binding: ActivityLowerBodyBackLungeBinding
    private lateinit var videoViewBackLunge: VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLowerBodyBackLungeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        videoViewBackLunge = findViewById(R.id.video1)
//        videoView2 = findViewById(R.id.videoView2)

        val videoUri1 = Uri.parse("android.resource://" + packageName + "/" + R.raw.backward_lunge)
//        val videoUri2 = Uri.parse("android.resource://" + packageName + "/" + R.raw.)

        videoViewBackLunge.setVideoURI(videoUri1)
//        videoView2.setVideoURI(videoUri2)

        videoViewBackLunge.start()
//        videoView2.start()

        videoViewBackLunge.setOnCompletionListener { mp ->
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

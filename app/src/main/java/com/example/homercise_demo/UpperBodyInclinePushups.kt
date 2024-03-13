package com.example.homercise_demo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import com.example.homercise_demo.databinding.ActivityUpperBodyInclinePushupsBinding

class UpperBodyInclinePushups : AppCompatActivity() {

    private lateinit var binding: ActivityUpperBodyInclinePushupsBinding
    private lateinit var videoViewInclinePushups: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpperBodyInclinePushupsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        videoViewInclinePushups = findViewById(R.id.video1)
//        videoView2 = findViewById(R.id.videoView2)

        val videoUri1 =
            Uri.parse("android.resource://" + packageName + "/" + R.raw.incline_pushups)
//        val videoUri2 = Uri.parse("android.resource://" + packageName + "/" + R.raw.)

        videoViewInclinePushups.setVideoURI(videoUri1)
//        videoView2.setVideoURI(videoUri2)

        videoViewInclinePushups.start()
//        videoView2.start()

        videoViewInclinePushups.setOnCompletionListener { mp ->
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
package com.example.homercise_demo

//import android.R
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.homercise_demo.databinding.ActivityUpperBodyJumpingBinding


class UpperBodyJumping : AppCompatActivity() {

    private lateinit var binding: ActivityUpperBodyJumpingBinding
    private lateinit var videoView1: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityUpperBodyJumpingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        videoView1 = findViewById(R.id.video1)
//        videoView2 = findViewById(R.id.videoView2)

        val videoUri1 = Uri.parse("android.resource://" + packageName + "/" + R.raw.jumping_jacks)
//        val videoUri2 = Uri.parse("android.resource://" + packageName + "/" + R.raw.)

        videoView1.setVideoURI(videoUri1)
//        videoView2.setVideoURI(videoUri2)

        videoView1.start()
//        videoView2.start()

        videoView1.setOnCompletionListener { mp ->
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
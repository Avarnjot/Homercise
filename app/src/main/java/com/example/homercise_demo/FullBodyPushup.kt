package com.example.homercise_demo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import com.example.homercise_demo.databinding.ActivityFullBodyPushupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FullBodyPushup : AppCompatActivity() {

    private lateinit var binding: ActivityFullBodyPushupBinding
    private lateinit var videoViewPushup: VideoView
    private lateinit var databaseRef: DatabaseReference
    private val userId: String? = FirebaseAuth.getInstance().currentUser?.uid
    private lateinit var databaseManager: DatabaseManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullBodyPushupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseRef = FirebaseDatabase.getInstance().reference
        databaseManager = DatabaseManager()

        videoViewPushup = findViewById(R.id.video1)
//        videoView2 = findViewById(R.id.videoView2)

        val videoUri1 = Uri.parse("android.resource://" + packageName + "/" + R.raw.push_up_exercise)
//        val videoUri2 = Uri.parse("android.resource://" + packageName + "/" + R.raw.)

        videoViewPushup.setVideoURI(videoUri1)
//        videoView2.setVideoURI(videoUri2)

        videoViewPushup.start()
//        videoView2.start()

        videoViewPushup.setOnCompletionListener { mp ->
            mp.start()    }


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

package com.example.homercise_demo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import com.example.homercise_demo.databinding.ActivityFullBodyBurpeesBinding
import com.example.homercise_demo.databinding.ActivityFullBodyKneePushupBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FullBodyKneePushup : AppCompatActivity() {

    private lateinit var binding: ActivityFullBodyKneePushupBinding
    private lateinit var videoViewKneePushup: VideoView
    private lateinit var databaseRef: DatabaseReference
    private val userId: String? = FirebaseAuth.getInstance().currentUser?.uid
    private lateinit var databaseManager: DatabaseManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullBodyKneePushupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this)
        val adView: AdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        databaseRef = FirebaseDatabase.getInstance().reference
        databaseManager = DatabaseManager()

        videoViewKneePushup = findViewById(R.id.video1)

        val videoUri1 = Uri.parse("android.resource://" + packageName + "/" + R.raw.knee_pushups)

        videoViewKneePushup.setVideoURI(videoUri1)

        videoViewKneePushup.start()

        videoViewKneePushup.setOnCompletionListener { mp ->
            mp.start()

        }

        binding.buttonAddToFavorites.setOnClickListener {
            databaseManager.saveActivityToDatabase(videoUri1.toString(), "Knee Pushups", this)
        }

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

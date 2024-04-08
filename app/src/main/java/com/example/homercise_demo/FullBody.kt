package com.example.homercise_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homercise_demo.databinding.ActivityFullBodyBinding
import com.example.homercise_demo.databinding.ActivityLowerBodyBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class FullBody : AppCompatActivity() {
    private lateinit var binding: ActivityFullBodyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullBodyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this)
        val adView: AdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

            binding.pushup.setOnClickListener {
                val intent = Intent(this, FullBodyPushup::class.java)
                startActivity(intent)
            }

        binding.burpees.setOnClickListener {
            val intent = Intent(this, FullBodyBurpees::class.java)
            startActivity(intent)
        }

        binding.kneePushup.setOnClickListener {
            val intent = Intent(this, FullBodyKneePushup::class.java)
            startActivity(intent)
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

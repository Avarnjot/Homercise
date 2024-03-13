package com.example.homercise_demo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import com.example.homercise_demo.databinding.ActivityLowerBodyBinding

class LowerBody : AppCompatActivity() {

    private lateinit var binding: ActivityLowerBodyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLowerBodyBinding.inflate(layoutInflater)
        setContentView(binding.root)



            binding.squats.setOnClickListener {
                val intent = Intent(this, LowerBodySquats::class.java)
                startActivity(intent)
            }

            binding.sideLeg.setOnClickListener {
                val intent = Intent(this, LowerBodySideLeg::class.java)
                startActivity(intent)
            }

            binding.backLunge.setOnClickListener {
                val intent = Intent(this, LowerBodyBackLunge::class.java)
                startActivity(intent)
            }

            binding.donkeyKick.setOnClickListener {
                val intent = Intent(this, LowerBodyDonkeyKick::class.java)
                startActivity(intent)
            }

            binding.jumpingSquats.setOnClickListener {
                val intent = Intent(this, LowerBodyJumpingSquats::class.java)
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


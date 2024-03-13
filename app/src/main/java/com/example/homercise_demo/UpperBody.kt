package com.example.homercise_demo

//import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.homercise_demo.databinding.ActivityUpperBodyBinding


class UpperBody : AppCompatActivity() {

    private lateinit var binding: ActivityUpperBodyBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityUpperBodyBinding.inflate(layoutInflater)
        setContentView(binding.root)


            binding.exerciseStretching.setOnClickListener {
                val intent = Intent(this, UpperBodyJumping::class.java)
                startActivity(intent)
            }


            binding.exerciseAbdominal.setOnClickListener {
                val intent = Intent(this, UpperBodyAbdominal::class.java)
                startActivity(intent)
            }


            binding.inclinePushups.setOnClickListener {
                val intent = Intent(this, UpperBodyInclinePushups::class.java)
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

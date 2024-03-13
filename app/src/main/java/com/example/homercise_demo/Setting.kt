package com.example.homercise_demo

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import com.example.homercise_demo.databinding.ActivityMainBinding
import com.example.homercise_demo.databinding.ActivitySettingBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class Setting : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding
    private lateinit var changeThemeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logout.setOnClickListener {
            Firebase.auth.signOut()
            startActivity(Intent(this, Login::class.java))
            finish()
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


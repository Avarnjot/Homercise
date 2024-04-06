package com.example.homercise_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homercise_demo.databinding.ActivityPersonalInfoBinding
import com.example.homercise_demo.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class PersonalInfo : AppCompatActivity() {

    private lateinit var binding: ActivityPersonalInfoBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_info)


        binding = ActivityPersonalInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()


        val userId = auth.currentUser?.uid
        val database = userId?.let {
            FirebaseDatabase.getInstance().getReference("Users")?.child(userId)
                ?.get()?.addOnSuccessListener {
                    binding.txtUserGender.text = "${it.child("gender").value.toString()}"
                    binding.txtUserAge.text = "${it.child("age").value ?: "N/A"}"
                    binding.txtUserHeight.text = "${it.child("height").value ?: "-"} cm"
                    binding.txtUserWeight.text = "${it.child("weight").value ?: "-"} kg"

                }
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
package com.example.homercise_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.homercise_demo.Login.Companion.auth
import com.example.homercise_demo.databinding.ActivityExerciseBinding
import com.example.homercise_demo.databinding.ActivityMainBinding
import com.example.homercise_demo.databinding.ActivityProfileBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Profile : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()


        val userId = auth.currentUser?.uid
        val database = userId?.let {
            FirebaseDatabase.getInstance().getReference("Users")?.child(userId)
                ?.get()?.addOnSuccessListener {
                    binding.txtUseremail.text = "${it.child("firstName").value.toString()}"
                    binding.txtUserGender.text = "${it.child("gender").value.toString()}"
                    binding.txtUserAge.text = "${it.child("age").value ?: "N/A"}"

                }
        }



//        binding.logout.setOnClickListener {
//            Firebase.auth.signOut()
//            startActivity(Intent(this, Login::class.java))
//            finish()
//        }


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

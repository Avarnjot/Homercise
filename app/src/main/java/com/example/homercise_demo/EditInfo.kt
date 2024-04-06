package com.example.homercise_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.homercise_demo.databinding.ActivityEditInfoBinding
import com.example.homercise_demo.databinding.ActivityExerciseBinding
import com.example.homercise_demo.databinding.ActivityPersonalInfoBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class EditInfo : AppCompatActivity() {

    private lateinit var binding: ActivityEditInfoBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userId = FirebaseAuth.getInstance().currentUser?.uid
        val database = userId?.let { FirebaseDatabase.getInstance().getReference("Users").child(it) }

        database?.get()?.addOnSuccessListener { snapshot ->
            val age = snapshot.child("age").value as? Int
            val height = snapshot.child("height").value as? Double
            val weight = snapshot.child("weight").value as? Double

            binding.editTextAge.setText(age.toString())
            binding.editTextHeight.setText(height.toString())
            binding.editTextWeight.setText(weight.toString())
        }

        binding.btnSave.setOnClickListener {
            // Update values in the database with new values from EditText fields
            val newAge = binding.editTextAge.text.toString().toInt()
            val newHeight = binding.editTextHeight.text.toString().toDouble()
            val newWeight = binding.editTextWeight.text.toString().toDouble()

            userId?.let {
                database?.child("age")?.setValue(newAge)
                database?.child("height")?.setValue(newHeight)
                database?.child("weight")?.setValue(newWeight)
            }

            Toast.makeText(this, "Personal info updated successfully", Toast.LENGTH_SHORT).show()
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
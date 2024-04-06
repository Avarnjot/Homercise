package com.example.homercise_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.homercise_demo.databinding.ActivityBmicalculatorBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class BMICalculator : AppCompatActivity() {

    private lateinit var binding: ActivityBmicalculatorBinding
    private lateinit var databaseRef: DatabaseReference
    private val userId: String? = FirebaseAuth.getInstance().currentUser?.uid

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmicalculator)

            databaseRef = FirebaseDatabase.getInstance().reference

        userId?.let { fetchUserDetails(it) }
    }


    private fun fetchUserDetails(userId: String) {
        val userRef = databaseRef.child("Users").child(userId)

        userRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(UserModel::class.java)
                user?.let { calculateBMI(it.height, it.weight) }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@BMICalculator, "Failed to fetch user data", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun calculateBMI(height: Double?, weight: Double?) {
        if (height != null && weight != null) {
            val heightInMeters = height / 100
            val bmi = weight / (heightInMeters * heightInMeters)
            displayBMI(bmi)
            displayBMICategory(bmi)
        } else {
            Toast.makeText(this, "User data incomplete", Toast.LENGTH_SHORT).show()
        }
    }

    private fun displayBMI(bmi: Double) {
        val formattedBMI = String.format("%.2f", bmi)
        val bmiTextView: TextView = findViewById(R.id.bmiTextView)
        bmiTextView.text = formattedBMI
    }


    private fun displayBMICategory(bmi: Double) {
        val bmiCategoryTextView: TextView = findViewById(R.id.bmiCategoryTextView)
        val category = getBMICategory(bmi)
        bmiCategoryTextView.text = "$category"
    }

    private fun getBMICategory(bmi: Double): String {
        return when {
            bmi < 18.5 -> "Underweight"
            bmi >= 18.5 && bmi < 25.0 -> "Healthy Weight"
            bmi >= 25.0 && bmi < 30.0 -> "Overweight"
            else -> "Obese"
        }
    }

}

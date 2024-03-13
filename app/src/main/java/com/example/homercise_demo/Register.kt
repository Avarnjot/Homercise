package com.example.homercise_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homercise_demo.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")


        binding.btnAccCreateAcc.setOnClickListener {
            val email = binding.edtxtAccEmail.text.toString()
            val password = binding.edtxtAccPass.text.toString()

            val fName = binding.edtxtFirstName.text.toString()
            val lName = binding.edtxtLastName.text.toString()
            val gender = binding.edtxtGender.text.toString()
            val age = binding.edtxtAge.text.toString().toIntOrNull()


            if (email.isNotEmpty() && password.isNotEmpty() && fName.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { authTask ->
                        if (authTask.isSuccessful) {
                            val currentUser = auth.currentUser
                            if (currentUser != null) {
                                val user = UserModel(fName, lName, gender, age)
                                databaseReference.child(currentUser.uid).setValue(user)
                                    .addOnCompleteListener { dbTask ->
                                        if (dbTask.isSuccessful) {
                                            Toast.makeText(this,"Account Created", Toast.LENGTH_LONG).show()
                                            startActivity(Intent(this, Login::class.java))
                                            finish()
                                        } else {
                                            Toast.makeText(this,"Unable to Create Account", Toast.LENGTH_LONG).show()
                                        }
                                    }
                            }
                        } else {
                            Toast.makeText(
                                this,
                                "Failed to create account: ${authTask.exception?.message}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_LONG).show()
            }
        }


    }
}
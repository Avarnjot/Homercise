package com.example.homercise_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homercise_demo.databinding.ActivityInLoginBinding
import com.example.homercise_demo.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class InLogin : AppCompatActivity() {

    private lateinit var binding: ActivityInLoginBinding

    companion object{
        lateinit var auth: FirebaseAuth
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Login.auth = FirebaseAuth.getInstance()

        binding = ActivityInLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.edtxtEmail.text.toString()
            val password = binding.edtxtPass.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                Login.auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Login Successfull", Toast.LENGTH_LONG).show()
                        //intent to home activity
                        startActivity(Intent(this, Home::class.java))
                        finish()
                    }
                }.addOnFailureListener {
                    Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}

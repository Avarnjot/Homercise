package com.example.homercise_demo

import android.content.Context
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DatabaseManager {
    private val databaseRef: DatabaseReference = FirebaseDatabase.getInstance().reference
    private val userId: String? = FirebaseAuth.getInstance().currentUser?.uid

    fun saveActivityToDatabase(videoUrl: String?, videoTitle: String, context: Context) {
        if (!userId.isNullOrEmpty() && videoUrl != null) {
            val favoritesRef = databaseRef.child("Users").child(userId).child("favorites")
            val activityKey = favoritesRef.push().key ?: ""
            favoritesRef.child(activityKey).setValue(ActivityModel(videoUrl, videoTitle))
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Activity saved successfully
                        Toast.makeText(context, "Activity added to favorites", Toast.LENGTH_SHORT).show()
                    } else {
                        // Error saving activity
                        Toast.makeText(context, "Failed to add activity to favorites", Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            // User not authenticated or video URL is null
            Toast.makeText(context, "User not authenticated or video URL is null", Toast.LENGTH_SHORT).show()
        }
    }
}
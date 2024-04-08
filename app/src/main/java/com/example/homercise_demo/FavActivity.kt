package com.example.homercise_demo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.VideoView
import com.example.homercise_demo.databinding.ActivityFavBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.example.homercise_demo.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class FavActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavBinding
    private lateinit var databaseRef: DatabaseReference
    private val userId: String? = FirebaseAuth.getInstance().currentUser?.uid
    private lateinit var videoView: VideoView
    private lateinit var previousButton: Button
    private lateinit var nextButton: Button
    private lateinit var deleteButton: Button
    private lateinit var sharedPreferences: SharedPreferences
    private var favoriteVideos = mutableListOf<String>()
    private var currentVideoIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this)
        val adView: AdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        videoView = findViewById(R.id.profile_video_view)
        previousButton = findViewById(R.id.previous_button)
        nextButton = findViewById(R.id.next_button)
        deleteButton = findViewById(R.id.delete_button)

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

        userId?.let { userId ->
            sharedPreferences = getSharedPreferences("Favorites_$userId", Context.MODE_PRIVATE)
            loadFavoriteVideosFromDatabase()
        }

        nextButton.setOnClickListener {
            currentVideoIndex = (currentVideoIndex + 1) % favoriteVideos.size
            playVideo(currentVideoIndex)
        }

        previousButton.setOnClickListener {
            currentVideoIndex = (currentVideoIndex - 1 + favoriteVideos.size) % favoriteVideos.size
            playVideo(currentVideoIndex)
        }

        deleteButton.setOnClickListener {
            if (favoriteVideos.isNotEmpty()) {
                val videoUrlToRemove = favoriteVideos[currentVideoIndex]
                removeVideoFromFavorites(videoUrlToRemove)
            }
        }
    }

    private fun loadFavoriteVideosFromDatabase() {
        val databaseRef = FirebaseDatabase.getInstance().getReference("Users").child(userId!!).child("favorites")
        databaseRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                favoriteVideos.clear()
                for (childSnapshot in snapshot.children) {
                    val videoUrl = childSnapshot.child("videoUrl").getValue(String::class.java)
                    videoUrl?.let {
                        favoriteVideos.add(it)
                    }
                }
                if (favoriteVideos.isNotEmpty()) {
                    playVideo(currentVideoIndex)
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    private fun playVideo(videoIndex: Int) {
        val videoUri = favoriteVideos[videoIndex]
        videoView.setVideoURI(Uri.parse(videoUri))
        videoView.start()
    }

    private fun removeVideoFromFavorites(videoUrl: String) {
        val databaseRef = FirebaseDatabase.getInstance().getReference("Users").child(userId!!).child("favorites")
        databaseRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (childSnapshot in snapshot.children) {
                    val url = childSnapshot.child("videoUrl").getValue(String::class.java)
                    if (url == videoUrl) {
                        childSnapshot.ref.removeValue().addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(this@FavActivity, "Video removed from favorites", Toast.LENGTH_SHORT).show()
                                favoriteVideos.remove(videoUrl)
                                if (favoriteVideos.isEmpty()) {
                                    videoView.stopPlayback()
                                } else {
                                    currentVideoIndex %= favoriteVideos.size
                                    playVideo(currentVideoIndex)
                                }
                            } else {
                                Toast.makeText(this@FavActivity, "Failed to remove video from favorites", Toast.LENGTH_SHORT).show()
                            }
                        }
                        break
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
}
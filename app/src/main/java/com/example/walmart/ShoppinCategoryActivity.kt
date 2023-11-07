package com.example.walmart

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ShoppingCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val username = intent.getStringExtra("username")

        val welcomeMessage = "Welcome, $username!"
        val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)
        welcomeTextView.text = welcomeMessage
    }

    fun onCategoryImageClick(view: View) {
        when (view.id) {
            R.id.clothingImage -> {
                Toast.makeText(this, "You have chosen the Clothing category of shopping", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

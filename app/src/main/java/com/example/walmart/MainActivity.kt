package com.example.walmart

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnSignIn: Button
    private lateinit var forgetPasswordTextView: TextView
    private lateinit var createAccountTextView: TextView

    private val users = ArrayList<User>() // Initialize with user data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnSignIn = findViewById(R.id.btnSignIn)
        forgetPasswordTextView = findViewById(R.id.forgetPasswordTextView)
        createAccountTextView = findViewById(R.id.createAccountTextView)

        users.add(User("Abdel", "Cheval", "abdel.cheval@example.com", "password123"))
        users.add(User("Alice", "Uho", "alice.uho@example.com", "abc@123"))


        btnSignIn.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            val user = users.find { it.username == username && it.password == password }

            if (user != null) {
                val intent = Intent(this, ShoppingCategoryActivity::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }

        forgetPasswordTextView.setOnClickListener {
            val userEmail = etUsername.text.toString()
            val user = users.find { it.username == userEmail }

            if (user != null) {
                val password = user.password
                // Use an implicit intent to send the password via email (configure email app)
                val emailIntent = Intent(Intent.ACTION_SEND)
                emailIntent.type = "text/plain"
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Password Recovery")
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Your password is: $password")
                startActivity(emailIntent)
            } else {
                Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show()
            }
        }

        createAccountTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}



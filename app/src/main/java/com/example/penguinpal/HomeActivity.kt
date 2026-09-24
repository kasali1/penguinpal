package com.example.penguinpal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.homeLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val welcomeGreeting = findViewById<TextView>(R.id.welcomeGreeting)
        val horoscopeBody = findViewById<TextView>(R.id.horoscopeBody)
        val logoutButton = findViewById<Button>(R.id.logoutButton)

        val catName = intent.getStringExtra("CAT_NAME") ?: "Cosmic Cat"
        val sunSign = intent.getStringExtra("SUN_SIGN") ?: ""

        if (catName.isNotEmpty()) {
            welcomeGreeting.text = "✨ WELCOME, ${catName.uppercase()}! ✨"
        }

        if (sunSign.isNotEmpty()) {
            horoscopeBody.text = "[$sunSign Cat Forecast]\n\nThe Moon aligns with your Sun sign today. Expect high energy during 3 AM zoomies, and a strong urge to lounge in a warm sunbeam. Treat yourself to extra catnip."
        }

        logoutButton.setOnClickListener {
            Toast.makeText(this, "Logged out of CATNI", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

package com.example.penguinpal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.signupLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val catNameInput = findViewById<EditText>(R.id.catNameInput)
        val sunSignInput = findViewById<EditText>(R.id.sunSignInput)
        val emailInput = findViewById<EditText>(R.id.signupEmailInput)
        val passwordInput = findViewById<EditText>(R.id.signupPasswordInput)
        val submitSignupButton = findViewById<Button>(R.id.submitSignupButton)
        val backToWelcome = findViewById<TextView>(R.id.signupBackToWelcome)

        submitSignupButton.setOnClickListener {
            val catName = catNameInput.text.toString().trim()
            val sunSign = sunSignInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (catName.isEmpty()) {
                Toast.makeText(this, "Please enter your Cat's Name", Toast.LENGTH_SHORT).show()
            } else if (email.isEmpty()) {
                Toast.makeText(this, "Please enter your Email", Toast.LENGTH_SHORT).show()
            } else if (password.isEmpty()) {
                Toast.makeText(this, "Please enter a Password", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Account created for $catName! ✨", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("CAT_NAME", catName)
                intent.putExtra("SUN_SIGN", sunSign)
                startActivity(intent)
                finish()
            }
        }

        backToWelcome.setOnClickListener {
            finish()
        }
    }
}

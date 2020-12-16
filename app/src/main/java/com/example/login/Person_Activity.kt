package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.TextValueSanitizer
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class Person_Activity : AppCompatActivity() {

    private lateinit var personInfoTextView: TextView
    private lateinit var changePasswordButton: Button
    private lateinit var logoutButton: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_)

        mAuth = FirebaseAuth.getInstance()

        personInfoTextView = findViewById(R.id.personInfoTextView)
        changePasswordButton = findViewById(R.id.passwordChangeButton)
        logoutButton = findViewById(R.id.logoutButton)

        personInfoTextView.text = mAuth.currentUser?.uid

        logoutButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            mAuth.signOut()
        }

        changePasswordButton.setOnClickListener {
            startActivity(Intent(this, PasswordChangeActivity::class.java))
        }

    }
}
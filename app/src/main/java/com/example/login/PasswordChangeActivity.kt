package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class PasswordChangeActivity : AppCompatActivity() {

    private lateinit var changePasswordEditText: EditText
    private lateinit var changePasswordButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_change)

        mAuth = FirebaseAuth.getInstance()

        changePasswordButton = findViewById(R.id.changePassButton)
        changePasswordEditText = findViewById(R.id.changePasswordEditText)

        changePasswordButton.setOnClickListener {
            val newpassword = changePasswordEditText.text.toString()

            if (newpassword.isEmpty()) {
                Toast.makeText(this, "5 ქულა ვერ მოიძებნა", Toast.LENGTH_LONG).show()
            } else {
                mAuth.currentUser?.updatePassword(newpassword)?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, Person_Activity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "5 ქულა ვერ მოიძებნა", Toast.LENGTH_LONG).show()
                    }

                }
            }

        }

    }
}
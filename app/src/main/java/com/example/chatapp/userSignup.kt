package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class userSignup : AppCompatActivity() {

    private lateinit var user_email: EditText
    private lateinit var user_name: EditText
    private lateinit var user_password: EditText
    private lateinit var btn_signup: Button
    private lateinit var btn_registered: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_signup)
        mAuth = FirebaseAuth.getInstance()
        //userSignup
        user_email = findViewById(R.id.user_email)
        user_name = findViewById(R.id.user_name)
        user_password = findViewById(R.id.user_password)

        //buttons
        btn_signup = findViewById(R.id.button_1)//signup
        btn_registered = findViewById(R.id.button_2)//login button reverts to login page


        btn_registered.setOnClickListener {
            val newIntent = Intent(this, userLogin::class.java)
            startActivity(newIntent)
        }

        btn_signup.setOnClickListener {
            val email = user_email.text.toString()
            val pass = user_password.text.toString()

            signUp(email, pass)
        }


    }

    private fun signUp(email: String, pass: String) {
        //signup,new users
        mAuth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful()) {
                    val intent = Intent(this@userSignup,MainActivity::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(this@userSignup,"Oops, We ran into some error",Toast.LENGTH_SHORT).show()
                }
            }

    }
}
package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class userLogin : AppCompatActivity() {

    private lateinit var user_name: EditText
    private lateinit var user_password: EditText
    private lateinit var btn_login: Button
    private lateinit var btn_signup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)
        //userlogin
        user_name = findViewById(R.id.user_email)
        user_password = findViewById(R.id.user_password)
        //buttons
        btn_login = findViewById(R.id.btn_login)
        btn_signup = findViewById(R.id.btn_signup)

        btn_signup.setOnClickListener{
            val intent = Intent(this, userSignup::class.java)
            startActivity(intent)
        }





    }
}
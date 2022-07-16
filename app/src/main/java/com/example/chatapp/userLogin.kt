package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class userLogin : AppCompatActivity() {

    private lateinit var user_name: EditText
    private lateinit var user_password: EditText
    private lateinit var btn_login: Button
    private lateinit var btn_signup: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)
        //FirebaseAuth
        mAuth = FirebaseAuth.getInstance()
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

        btn_login.setOnClickListener{
            val user_email =user_name.text.toString()
            val user_pass=user_password.text.toString()

            login(user_email,user_pass);

        }

    }

    private fun login(user_email:String,user_pass:String){
        mAuth.signInWithEmailAndPassword(user_email, user_pass)
            .addOnCompleteListener(this){ task ->
                    if (task.isSuccessful()) {
                        val intent = Intent(this@userLogin,MainActivity::class.java)
                        startActivity(intent)

                    } else {
                        Toast.makeText(this@userLogin,"Oops, It seems we couldn't log you in",Toast.LENGTH_SHORT).show()

                    }
            }
    }
}
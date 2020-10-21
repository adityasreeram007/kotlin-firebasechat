package com.example.firebasechat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main)
        var mAuth:FirebaseAuth?=null;
        mAuth=FirebaseAuth.getInstance()
        try{
        val username:EditText=findViewById(R.id.username)!!
        val password:EditText=findViewById(R.id.password)!!
        val auth:Button=findViewById(R.id.auth)
            auth.setOnClickListener{
                val usetext:String=username.text.toString();
                val passtext:String=password.text.toString();
                if (usetext.isNotEmpty() && passtext.isNotEmpty()){
                mAuth.signInWithEmailAndPassword(usetext, passtext)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("TAG", "signInWithEmail:success")
                                val intent = Intent(this,Chatbox::class.java)
                                startActivity(intent)

                            } else {

                                Log.w("TAG", "signInWithEmail:failure", task.exception)
                                Toast.makeText(baseContext, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show()


                            }

                            // ...
                        }}

        }}
        catch (e:Exception){


            Toast.makeText(baseContext, "Authentication failed.",
                    Toast.LENGTH_SHORT).show()
            Log.d("e",e.stackTraceToString())
            Log.d("hello","hello")
        }






    }
}
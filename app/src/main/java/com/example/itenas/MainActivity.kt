package com.example.itenas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var login : Button
    lateinit var register: TextView
    lateinit var Password : EditText
    lateinit var Username : EditText

    fun button(){
        login = findViewById(R.id.Login)
        register = findViewById(R.id.Register)
        Password = findViewById(R.id.password)
        Username = findViewById(R.id.username)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button()

        register.setOnClickListener {
            var intent = Intent(this,Registration::class.java)
            startActivity(intent)
        }

        Password.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                (event != null && event.action == KeyEvent.ACTION_DOWN && event.keyCode == KeyEvent.KEYCODE_ENTER)
            ) {
                aksiLogin()
                return@setOnEditorActionListener true
            }
            false
        }

        login.setOnClickListener{
            aksiLogin()
        }

    }

    private fun aksiLogin(){
        if(Username.text.toString().isBlank() && Password.text.toString().isBlank()){
            Toast.makeText(this,"Username and password cannot be empty",Toast.LENGTH_SHORT).show()
        }else if (Username.text.toString().isBlank()){
            Toast.makeText(this,"Username cannot be empty",Toast.LENGTH_SHORT).show()
        }else if(Password.text.toString().isBlank()){
            Toast.makeText(this,"Password cannot be empty",Toast.LENGTH_SHORT).show()
        }else if(!Username.text.toString().equals("ariq.bagus")){
            Toast.makeText(this,"Account not found",Toast.LENGTH_SHORT).show()
        }else if(Username.text.toString().equals("ariq.bagus") && Password.text.toString()!=("a")){
            Toast.makeText(this,"Wrong password",Toast.LENGTH_SHORT).show()
        }else if(Username.text.toString().equals("ariq.bagus") && Password.text.toString().equals("a")){
            var pindah = Intent(this,FragmentActivity::class.java)
            var ambil = Username.getText().toString()
            pindah.putExtra("textToDisplay", ambil)
            startActivity(pindah)
        }
    }
}
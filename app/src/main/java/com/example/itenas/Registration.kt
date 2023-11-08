package com.example.itenas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Registration : AppCompatActivity() {
    private lateinit var register : Button
    private lateinit var kembali : TextView
    private lateinit var username : EditText
    private lateinit var password : EditText
    private lateinit var secondpassword : EditText

    private fun button (){
        register = findViewById(R.id.buttonRegister)
        kembali = findViewById(R.id.buttonkembali)
        username = findViewById(R.id.username_register)
        password = findViewById(R.id.password_register)
        secondpassword = findViewById(R.id.password_con)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        button()

        kembali.setOnClickListener{
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        register.setOnClickListener {
            var name = username.text.toString()
            var password1 = password.text.toString()
            var password1_second = secondpassword.text.toString()
            var value = checkregister(name, password1, password1_second)
            Log.i("value : ", password1_second)
            when(value){
                1 -> Toast.makeText(this,"Username, password, and confirm password cannot be empty",Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(this,"Username and password cannot be empty, whilst confirm password have to be more than 5 letter ",Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(this,"Username cannot be empty,  whilst password and confirm password have to be more than 5 letter ",Toast.LENGTH_SHORT).show()
                4 -> Toast.makeText(this,"Username have to be more than 5 letter, whilst password and confirm password cannot be empty ",Toast.LENGTH_SHORT).show()
                5 -> Toast.makeText(this,"Username and password have to be more than 5 letter, whilst confirm password cannot be empty ",Toast.LENGTH_SHORT).show()
                6 -> Toast.makeText(this,"Username and confirm password have to be more than 5 letter, whilst password cannot be empty ",Toast.LENGTH_SHORT).show()
                7 -> Toast.makeText(this,"Username, password, and confirm password have to be more than 5 letter ",Toast.LENGTH_SHORT).show()
                8 -> Toast.makeText(this,"Username and password cannot be empty",Toast.LENGTH_SHORT).show()
                9 -> Toast.makeText(this,"Password and confirm password cannot be empty",Toast.LENGTH_SHORT).show()
                10 -> Toast.makeText(this,"Username have to be more than 5 letter whilst password cannot be empty ",Toast.LENGTH_SHORT).show()
                11 -> Toast.makeText(this,"Username have to be more than 5 letter whilst confirm password cannot be empty ",Toast.LENGTH_SHORT).show()
                12 -> Toast.makeText(this,"Username cannot be empty whilst password have to be more than 5 letter",Toast.LENGTH_SHORT).show()
                13 -> Toast.makeText(this,"Password cannot be empty whilst confirm password have to be more than 5 letter",Toast.LENGTH_SHORT).show()
                14 -> Toast.makeText(this,"Password and confirm password have to be more than 5 letter",Toast.LENGTH_SHORT).show()
                15 -> Toast.makeText(this,"Username cannot be empty",Toast.LENGTH_SHORT).show()
                16 -> Toast.makeText(this,"Password cannot be empty",Toast.LENGTH_SHORT).show()
                17 -> Toast.makeText(this,"Confirm Password cannot be empty ",Toast.LENGTH_SHORT).show()
                18 -> Toast.makeText(this,"Username have to be more than 5 letter",Toast.LENGTH_SHORT).show()
                19 -> Toast.makeText(this,"Password have to be more than 5 letter ",Toast.LENGTH_SHORT).show()
                20 -> Toast.makeText(this,"Confirm Password have to be more than 5 letter ",Toast.LENGTH_SHORT).show()
                21 -> Toast.makeText(this,"Confirm Password is not the same with Password",Toast.LENGTH_SHORT).show()
                0 -> register.setOnClickListener {
                    var intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    private fun checkregister(username: String, password: String, password1: String): Any {
        var value = 0

        if(username.isBlank() && password.isBlank() && password1.isBlank()) {
            return 1
        }else if(username.isBlank() && password.isBlank() && password1.length < 5 ) {
            return 2
        }else if(username.isBlank() && password.length < 5 && password1.length < 5){
            return 3
        }else if(username.length < 5 && password.isBlank()  && password1.isBlank()){
            return 4
        }else if(username.length < 5 && password.length < 5 && password1.isBlank()){
            return 5
        }else if(username.length < 5 && password.isBlank() && password.length < 5){
            return 6
        }else if(username.length < 5 && password.length < 5 && password.length < 5){
            return 7
        }else if (username.isBlank() && password.isBlank()){
            return 8
        }else if(username.isBlank() && password1.isBlank()){
            return 9
        }else if(username.length < 5 && password.isBlank()){
            return 10
        }else if(username.length < 5 && password1.isBlank()){
            return 11
        }else if(username.isBlank() && password.length < 5){
            return 12
        }else if(username.isBlank() && password1.length < 5){
            return 13
        }else if(password.length < 5 && password1.length < 5){
            return 14
        }else if(username.isBlank()){
            return 15
        }else if(password.isBlank()){
            return 16
        }else if(password1.isBlank()){
            return 17
        }else if(username.length < 5){
            return 18
        }else if(password.length < 5){
            return 19
        }else if (password1.length < 5){
            return  20
        }else if(password != password1){
            return 21
        }
        return 0
    }

}
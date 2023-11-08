package com.example.itenas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Faculty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculty)

        val btn_back = findViewById<ImageView>(R.id.btn_back)

        btn_back.setOnClickListener{
            var pindah = Intent(this,FragmentActivity::class.java)
            var ambil = intent.getStringExtra("uText")
            pindah.putExtra("textToDisplay", ambil)
            startActivity(pindah)
        }

    }
}
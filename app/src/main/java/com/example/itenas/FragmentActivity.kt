package com.example.itenas

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.itenas.fragments.fBmi
import com.example.itenas.fragments.fCalculator
import com.example.itenas.fragments.fHome
import com.example.itenas.fragments.fMoney
import com.example.itenas.fragments.fProfile
import com.google.android.material.bottomnavigation.BottomNavigationView

class FragmentActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        var txt_username = intent.getStringExtra("textToDisplay")

        fun loadFragment(fragment: Fragment){
            val mFragment = fragment
            val mBundle = Bundle()
            mBundle.putString("uText",txt_username)
            mFragment.arguments = mBundle
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container,mFragment)
            transaction.commit()
        }

        loadFragment(fHome())

        bottomNav = findViewById(R.id.bottom_nav) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bot_menu_home -> {
                    loadFragment(fHome())
                    true
                }
                R.id.bot_menu_calculator -> {
                    loadFragment(fCalculator())
                    true
                }
                R.id.bot_menu_money -> {
                    loadFragment(fMoney())
                    true
                }
                R.id.bot_menu_bmi -> {
                    loadFragment(fBmi())
                    true
                }
                R.id.bot_menu_profile -> {
                    loadFragment(fProfile())
                    true
                }

                else -> {
                    false
                }
            }
        }
    }
}
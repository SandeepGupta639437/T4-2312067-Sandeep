package com.example.csi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private val homepage=Home_Page()
    private val profilepage=Profile_Page()
    private val settingpage=Setting_Page()
    private val analysispage=Analysis_Page()
    private val timerpage=Timer_Page()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView2)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homeic->replaceFragment(homepage)
                R.id.analysics->replaceFragment(analysispage)
                R.id.timer->replaceFragment(timerpage)
                R.id.settingsic->replaceFragment(settingpage)
                R.id.profileic->replaceFragment(profilepage)
            }
            true
        }
        replaceFragment(homepage)

    }
    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
           val transaction=supportFragmentManager.beginTransaction()
           transaction.replace(R.id.frame_layout2, fragment)
           transaction.commit()
        }
    }
}
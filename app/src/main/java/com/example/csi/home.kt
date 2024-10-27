package com.example.csi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.csi.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = Home_Page()
        val profileFragment = Profile_Page()
        val settingFragment = Setting_Page()
        val analysisFragment = Analysis_Page()
        val timerFragment = Timer_Page()

        makeCurrentFragment(homeFragment)

        binding.bottomNavigationView.setOnItemSelectedListener { item->
            when (item.itemId) {
                R.id.homeic -> makeCurrentFragment(homeFragment)
                R.id.profileic -> makeCurrentFragment(profileFragment)
                R.id.settingsic ->makeCurrentFragment(settingFragment)
                R.id.timer->makeCurrentFragment(timerFragment)
                R.id.analysics->makeCurrentFragment(analysisFragment)
            }
            true
        }

        // Edge-to-edge insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_layout,fragment)
            fragmentTransaction.commit()
    }
}

package com.example.saturnaliav1.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.saturnaliav1.R
import com.example.saturnaliav1.databinding.ActivityMainBinding
import com.example.saturnaliav1.ui.fragments.config.ConfigFragment
import com.example.saturnaliav1.ui.fragments.info.InfoFragment
import com.example.saturnaliav1.ui.fragments.profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
/*
        val navView: BottomNavigationView = binding.bottomNavigationView
        val navController = findNavController(R.id.frame_layout)
        navController.addOnDestinationChangedListener{_,destination,_->
            if (destination.id == R.id.loginFragment || destination.id == R.id.registerFragment)
                navView.visibility = View.GONE
            else
                navView.visibility = View.VISIBLE
        }
*/
        replaceFragment(ProfileFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.perfil-> replaceFragment(ProfileFragment())
                R.id.config -> replaceFragment(ConfigFragment())
                R.id.info -> replaceFragment(InfoFragment())

                else ->{

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.constrain_layout, fragment)
        fragmentTransaction.commit()
    }
}
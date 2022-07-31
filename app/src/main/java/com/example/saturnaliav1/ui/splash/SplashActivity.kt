package com.example.saturnaliav1.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.saturnaliav1.R
import com.example.saturnaliav1.databinding.ActivitySplashBinding
import com.example.saturnaliav1.ui.main.MainActivity
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {
    private lateinit var splashBinding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        val view = splashBinding.root
        setContentView(view)
        //Temporizador para retornar al ui.main Activity
        val timer = Timer()
        timer.schedule(
            timerTask{
                goToMainActivity()
            }, 1000
        )
    }

    private fun goToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
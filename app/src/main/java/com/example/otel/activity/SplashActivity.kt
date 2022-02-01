package com.example.otel.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.otel.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        scheduleSplashScreen()
    }

    private fun scheduleSplashScreen() {
        val splashScreenDuration : Long = 2000

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent (this@SplashActivity, MainActivity::class.java)
            startActivity(intent)

            finish()
        }, splashScreenDuration)
    }
}
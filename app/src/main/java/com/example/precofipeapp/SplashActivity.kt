package com.example.precofipeapp


import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.ComponentActivity

class SplashActivity : ComponentActivity() {

    lateinit var imageAutomovel: ImageView
    lateinit var animation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        imageAutomovel = findViewById(R.id.imageAutomovel)

        val it = Intent(this, LoginActivity::class.java)

        animation = AnimationUtils.loadAnimation(this, R.anim.splash)
        animation.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                startActivity(it)
            }

            override fun onAnimationRepeat(animation: Animation?) {}

        })

        imageAutomovel.setAnimation(animation)
        animation.start()
    }
}
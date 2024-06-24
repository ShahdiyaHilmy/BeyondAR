package com.example.beyondar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Categories : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_categories)

        val location: Button = findViewById(R.id.Location)

        location.setOnClickListener {
            val intent = Intent(this, Location::class.java)
            startActivity(intent)
        }

        val Random: Button = findViewById(R.id.Object)

        Random.setOnClickListener {
            val intent = Intent(this, Object::class.java)
            startActivity(intent)
        }



    }
}
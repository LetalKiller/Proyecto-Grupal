package com.example.proyecto_grupal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnP: Button = findViewById(R.id.botonP);
        btnP.setOnClickListener ({
            val intent1: Intent = Intent(this, Plantilla::class.java)
            startActivity(intent1)
        })
        val btnH: Button = findViewById(R.id.botonH);
        btnH.setOnClickListener ({
            val intent2: Intent = Intent(this, Historia::class.java)
            startActivity(intent2)
        })
        val btnU: Button = findViewById(R.id.botonU);
        btnU.setOnClickListener ({
            val intent3: Intent = Intent(this, Uniforme::class.java)
            startActivity(intent3)
        })
        val btnE: Button = findViewById(R.id.botonE);
        btnE.setOnClickListener ({
            val intent4: Intent = Intent(this, Estadio::class.java)
            startActivity(intent4)
        })

    }
}
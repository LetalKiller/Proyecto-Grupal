package com.example.proyecto_grupal

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Plantilla : AppCompatActivity() {

    private lateinit var txtplantilla: TextView
    private lateinit var txtjugadores: TextView
    private var indicePlantilla = 0
    private val delayMillis: Long = 10000



    private val plantilla = arrayOf(
        "2015: Primera dinastía moderna\n\n" +
                "1. Stephen Curry\n" +
                "2. Klay Thompson\n" +
                "3. Draymond Green\n" +
                "4. Andre Iguodala (MVP de las finales)\n" +
                "5. Harrison Barnes\n" +
                "6. Andrew Bogut\n" +
                "7. Shaun Livingston",

        "2017: El súper equipo\n\n" +
                "1. Stephen Curry\n" +
                "2. Klay Thompson\n" +
                "3. Draymond Green\n" +
                "4. Kevin Durant (MVP de las finales)\n" +
                "5. Andre Iguodala\n" +
                "6. JaVale McGee\n" +
                "7. David West",

        "2022: El regreso triunfal\n\n" +
                "1. Stephen Curry (MVP de las finales)\n" +
                "2. Klay Thompson\n" +
                "3. Draymond Green\n" +
                "4. Andrew Wiggins\n" +
                "5. Jordan Poole\n" +
                "6. Kevon Looney\n" +
                "7. Gary Payton II"

    )





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_plantilla)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtplantilla = findViewById(R.id.txtplantilla)
        txtjugadores= findViewById(R.id.txtjugadores)

        mostrarPlantilla()

        val btnP: Button = findViewById(R.id.botonP);
        btnP.setOnClickListener ({
            val intent1: Intent = Intent(this, MainActivity::class.java)
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

    private fun mostrarPlantilla(){
        val handler = Handler(Looper.getMainLooper())

        val runnable = object : Runnable{
            override fun run() {
                txtplantilla.text = "Plantilla"
                txtjugadores.text = plantilla[indicePlantilla]
                indicePlantilla = (indicePlantilla + 1) % plantilla.size
                handler.postDelayed(this, delayMillis)
            }
        }
        handler.post(runnable)

    }


}
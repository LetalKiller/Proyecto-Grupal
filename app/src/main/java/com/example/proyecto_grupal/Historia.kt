package com.example.proyecto_grupal

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Historia : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var textView4: TextView

    private val historia = arrayOf(
        "Los Golden State Warriors fueron fundados en 1946 como los Philadelphia Warriors.",
        "En 1962, el equipo se trasladó a San Francisco y se convirtió en los San Francisco Warriors.",
        "En 1971, cambiaron su nombre a Golden State Warriors.",
        "En 2015, lograron su primer título de la NBA en 40 años liderados por Stephen Curry.",
        "Desde entonces, han ganado múltiples campeonatos y son conocidos por su estilo de juego único.",

        )
    private val titulos= arrayOf(
        "Los Warriors han tenido una rivalidad notable con los Cleveland Cavaliers, especialmente durante las finales de la NBA de 2015 a 2018, donde se enfrentaron cuatro veces consecutivas.\n\n" +
                "El entrenador Steve Kerr ha sido fundamental en el éxito reciente del equipo, ganando varios campeonatos desde su llegada en 2014.\n\n" +
                "Stephen Curry, considerado uno de los mejores tiradores en la historia de la NBA, ha cambiado la percepción del tiro de larga distancia, siendo dos veces MVP de la liga.\n\n" +
                "Los Warriors juegan sus partidos como local en el Chase Center, ubicado en San Francisco, que se inauguró en 2019.\n\n"+
                "Hasta la temporada 2022-2023, los Golden State Warriors tienen un total de 7 títulos de la NBA, ganados en los años:\n\n" +
                "1. 1947 (como Philadelphia Warriors)\n" +
                "2. 1956 (como Philadelphia Warriors)\n" +
                "3. 1975 (como Golden State Warriors)\n" +
                "4. 2015 (liderados por Stephen Curry)\n" +
                "5. 2017 (liderados por Stephen Curry y Kevin Durant)\n" +
                "6. 2018 (liderados por Stephen Curry y Kevin Durant)\n" +
                "7. 2022 (liderados por Stephen Curry)"
    )

    private var indiceHistoria = 0
    private val delayMillis: Long = 8000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_historia)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imageView = findViewById(R.id.imageView)
        textView2 = findViewById(R.id.textView2)
        textView2.text = "Historia"
        textView3 = findViewById(R.id.textView3)
        textView4 = findViewById(R.id.textView5)
        textView4.text = titulos.joinToString(separator = "\n\n")

        mostrarHistoria()

        val btnP: Button = findViewById(R.id.botonP);
        btnP.setOnClickListener ({
            val intent1: Intent = Intent(this, Plantilla::class.java)
            startActivity(intent1)
        })
        val btnH: Button = findViewById(R.id.botonH);
        btnH.setOnClickListener ({
            val intent2: Intent = Intent(this, MainActivity::class.java)
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
    private fun mostrarHistoria() {

        val handler = Handler(Looper.getMainLooper())

        val runnable = object : Runnable {
            override fun run() {
                textView3.text = historia[indiceHistoria]
                indiceHistoria = (indiceHistoria + 1) % historia.size
                handler.postDelayed(this, delayMillis)
            }
        }

        handler.post(runnable)
    }
}
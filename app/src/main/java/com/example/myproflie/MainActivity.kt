package com.example.myproflie

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Email Butonu
        findViewById<Button>(R.id.btn_email).setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:example@example.com") // Mail adresinizi buraya girin
            }
            startActivity(emailIntent)
        }

        // Telefon Butonu
        findViewById<Button>(R.id.btn_phone).setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:+123456789") // Telefon numarasını buraya girin
            }
            startActivity(phoneIntent)
        }

        // Lokasyon Butonu
        findViewById<Button>(R.id.btn_location).setOnClickListener {
            val locationIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("geo:0,0?q=Baku") // Yer ismini buraya girin
            }
            startActivity(locationIntent)
        }

        // Müzik Çalma Butonu
        findViewById<Button>(R.id.btn_play_music).setOnClickListener {
            if (::mediaPlayer.isInitialized) {
                mediaPlayer.release()
            }
            mediaPlayer = MediaPlayer.create(this, R.raw.sample_music) // `res/raw` içine bir müzik eklemelisiniz.
            mediaPlayer.start()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
    }
}

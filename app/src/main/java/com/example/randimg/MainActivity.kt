package com.example.randimg

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

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

    val BtnRandomizar: Button = findViewById(R.id.BtnRandomizar)
    val TvImgRandom: ImageView = findViewById(R.id.TvImgRandom)

        val images = listOf(
            "https://picsum.photos/id/1015/600/400",
            "https://picsum.photos/id/1025/600/400",
            "https://picsum.photos/id/1035/600/400",
            "https://picsum.photos/id/1045/600/400",
            "https://picsum.photos/id/1055/600/400",
            "https://picsum.photos/id/1065/600/400",
            "https://picsum.photos/id/1075/600/400",
            "https://picsum.photos/id/1085/600/400"
        )

        BtnRandomizar.setOnClickListener{
            val randomImage = images.random()
            Glide.with(this)
                .load(randomImage)
                .into(TvImgRandom)
        }
    }
}
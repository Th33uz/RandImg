package com.example.randimg

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

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
            "https://picsum.photos/seed/picsum/600/400",
            "https://picsum.photos/id/237/600/400",
            "https://picsum.photos/id/29/600/400",
            "https://picsum.photos/id/68/600/400",
            "https://picsum.photos/id/74/600/400",
            "https://picsum.photos/id/103/600/400",
            "https://picsum.photos/id/155/600/400",
            "https://picsum.photos/id/152/600/400"
        )

        BtnRandomizar.setOnClickListener{
            val randomImage = images.random()
            val progressBarHorizontal: ProgressBar = findViewById(R.id.progressBar_1)
            progressBarHorizontal.visibility = View.VISIBLE
            progressBarHorizontal.isIndeterminate = true

            Glide.with(this)
                .load(randomImage)
                .listener(object : RequestListener<android.graphics.drawable.Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<android.graphics.drawable.Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {

                        progressBarHorizontal.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(
                        resource: android.graphics.drawable.Drawable?,
                        model: Any?,
                        target: Target<android.graphics.drawable.Drawable>?,
                        dataSource: com.bumptech.glide.load.DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {

                        progressBarHorizontal.visibility = View.GONE
                        return false
                    }
                })
                .into(TvImgRandom)

        }

    }
}
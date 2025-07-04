package com.example.vehicletrackingsystem.uiDesign

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.vehicletrackingsystem.R
import com.github.chrisbanes.photoview.PhotoView

class ImageZoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_zoom)

        val photoView = findViewById<PhotoView>(R.id.photoView)
        val imageResId = intent.getIntExtra("image_res_id", R.drawable.svpinfotech_logo)
        photoView.setImageResource(imageResId)

        // Optional: Tap to close
        photoView.setOnClickListener {
            finish()
        }
    }
}

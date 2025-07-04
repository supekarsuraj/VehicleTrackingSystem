package com.example.vehicletrackingsystem.uiDesign

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.vehicletrackingsystem.HomeActivity
import com.example.vehicletrackingsystem.R
import com.google.android.material.navigation.NavigationView

class VehicleDocumentActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var ivMenu: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_document)

        // Drawer setup
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        ivMenu = findViewById(R.id.ivMenu)

        val tvVehicleNumber = findViewById<TextView>(R.id.tvVehicleNumber)
        val vehicleNo = intent.getStringExtra("vehicle_number")
        tvVehicleNumber.text = "Vehicle No: $vehicleNo"

        ivMenu.setOnClickListener {
            drawerLayout.openDrawer(navigationView)
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_about_us -> {
                    startActivity(Intent(this, AboutUsActivity::class.java))
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_privacy_policy -> {
                    startActivity(Intent(this, TermsConditionsActivity::class.java))
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_terms_conditions -> {
                    startActivity(Intent(this, TermsConditionsActivity::class.java))
                    drawerLayout.closeDrawers()
                    true
                }
                else -> false
            }
        }

        // Setup image click listeners
        val ivInsurance = findViewById<ImageView>(R.id.ivInsurance)
        val ivPUC = findViewById<ImageView>(R.id.ivPUC)
        val ivFitness = findViewById<ImageView>(R.id.ivFitness)
        val ivPermit = findViewById<ImageView>(R.id.ivPermit)
        val ivTax = findViewById<ImageView>(R.id.ivTax)

        ivInsurance.setOnClickListener { openZoomActivity(R.drawable.svpinfotech_logo) }
        ivPUC.setOnClickListener { openZoomActivity(R.drawable.svpinfotech_logo) }
        ivFitness.setOnClickListener { openZoomActivity(R.drawable.svpinfotech_logo) }
        ivPermit.setOnClickListener { openZoomActivity(R.drawable.svpinfotech_logo) }
        ivTax.setOnClickListener { openZoomActivity(R.drawable.svpinfotech_logo) }
    }

    private fun openZoomActivity(imageResId: Int) {
        val intent = Intent(this, ImageZoomActivity::class.java)
        intent.putExtra("image_res_id", imageResId)
        startActivity(intent)
    }
}

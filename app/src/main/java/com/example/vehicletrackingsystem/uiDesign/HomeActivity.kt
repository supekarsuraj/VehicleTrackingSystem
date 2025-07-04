package com.example.vehicletrackingsystem

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.vehicletrackingsystem.uiDesign.AboutUsActivity
import com.example.vehicletrackingsystem.uiDesign.TermsConditionsActivity
import com.example.vehicletrackingsystem.uiDesign.VehicleDocumentActivity
import com.google.android.material.navigation.NavigationView
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.io.IOException
import androidx.cardview.widget.CardView


class HomeActivity : AppCompatActivity() {

    private val TAG = "HomeActivity"

    private lateinit var tvVehicalNo: TextView
    private lateinit var tvVehicalName: TextView
    private lateinit var tvDriverId: TextView
    private lateinit var tvUserId: TextView
    private lateinit var tvWelcome: TextView

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var ivMenu: ImageView
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val username = intent.getStringExtra("username") ?: "User"
        val userId = intent.getStringExtra("userId") ?: "4"

        tvWelcome = findViewById(R.id.tvWelcome)
        val tvHeaderTitle = findViewById<TextView>(R.id.tvHeaderTitle)
        tvHeaderTitle.text = "Vehicle Tracking"

        drawerLayout = findViewById(R.id.drawer_layout)
        ivMenu = findViewById(R.id.ivMenu)
        navigationView = findViewById(R.id.navigation_view)

        ivMenu.setOnClickListener {
            drawerLayout.openDrawer(navigationView)
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
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
                    startActivity(Intent(this, AboutUsActivity::class.java))
                    drawerLayout.closeDrawers()
                    true
                }
                else -> false
            }
        }

        tvVehicalNo = findViewById(R.id.tvVehicalNo)
        tvVehicalName = findViewById(R.id.tvVehicalName)
        tvDriverId = findViewById(R.id.tvDriverId)
        tvUserId = findViewById(R.id.tvUserId)

        callGetVehicleListApi(userId)
        val vehicleDocumentCard = findViewById<CardView>(R.id.cardVehicleDocument)

        vehicleDocumentCard.setOnClickListener {
            val vehicleNumber = tvVehicalNo.text.toString().replace("Vehicle No: ", "")
            val intent = Intent(this, VehicleDocumentActivity::class.java)
            intent.putExtra("vehicle_number", vehicleNumber)
            startActivity(intent)
        }



    }

    private fun callGetVehicleListApi(userId: String) {
        val client = OkHttpClient()

        val url = "https://fleet.customerp.app/app/external/GetVehicalList?UserId=$userId"
        Log.d(TAG, "Vehicle List URL: $url")

        val request = Request.Builder()
            .url(url)
            .build()

        Thread {
            try {
                client.newCall(request).execute().use { response ->
                    if (!response.isSuccessful) {
                        Log.e(TAG, "Unexpected code $response")
                    } else {
                        val responseBody = response.body?.string()
                        Log.d(TAG, "Vehicle List Response: $responseBody")

                        val jsonObject = JSONObject(responseBody ?: "{}")

                        val vehicalNo = jsonObject.optString("VehicalNo", "N/A")
                        val name = jsonObject.optString("Name", "N/A")
                        val driverId = jsonObject.optInt("DriverId", 0)
                        val userIdResponse = jsonObject.optInt("UserId", 0)

                        runOnUiThread {
                            tvVehicalNo.text = "Vehicle No: $vehicalNo"
                            tvVehicalName.text = "Name: $name"
                            tvDriverId.text = "Driver ID: $driverId"
                            tvUserId.text = "User ID: $userIdResponse"
                            tvWelcome.text = "Welcome, $name!"
                        }
                    }
                }
            } catch (e: IOException) {
                Log.e(TAG, "API call failed: ${e.message}")
            }
        }.start()
    }
}

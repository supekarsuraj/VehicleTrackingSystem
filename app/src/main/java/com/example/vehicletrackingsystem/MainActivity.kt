package com.example.vehicletrackingsystem

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.InputType
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import android.app.DownloadManager
import android.content.Intent
import org.json.JSONObject




class MainActivity : AppCompatActivity() {

    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val ivTogglePassword = findViewById<ImageView>(R.id.ivTogglePassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        ivTogglePassword.setOnClickListener {
            if (isPasswordVisible) {
                etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                ivTogglePassword.setImageResource(R.drawable.ic_eye)
                isPasswordVisible = false
            } else {
                etPassword.inputType = InputType.TYPE_CLASS_TEXT
                ivTogglePassword.setImageResource(R.drawable.ic_eye_off)
                isPasswordVisible = true

                Handler(Looper.getMainLooper()).postDelayed({
                    etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                    ivTogglePassword.setImageResource(R.drawable.ic_eye)
                    isPasswordVisible = false
                }, 2000)
            }
            etPassword.setSelection(etPassword.text.length)
        }

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            callVerifyUserApi(username, password)
        }
    }

    private fun callVerifyUserApi(username: String, password: String) {
        val client = OkHttpClient()

        val url = "https://fleet.customerp.app/app/external/ApiVerifyuser?Username=$username&ApiPassword=$password"
        Log.d("MainActivity", "Request URL: $url")

        val request = Request.Builder()
            .url(url)
            .build()

        Thread {
            try {
                client.newCall(request).execute().use { response ->
                    if (!response.isSuccessful) {
                        Log.e("Suraj", "Unexpected code $response")
                        runOnUiThread {
                            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        val responseBody = response.body?.string()
                        Log.d("Suraj", "API Response: $responseBody")

                        val jsonObject = JSONObject(responseBody ?: "{}")
                        val status = jsonObject.optString("Status", "")
                        val message = jsonObject.optString("Message", "")

                        val userId = jsonObject.optString("UserId", "4")

                        runOnUiThread {
                            if (status == "200") {
                                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()

                                val intent = Intent(this, HomeActivity::class.java)
                                intent.putExtra("username", username)
                                intent.putExtra("userId", userId) // ✅ pass UserId
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                            }
                        }


                    }
                }
            } catch (e: IOException) {
                Log.e("Suraj", "API call failed: ${e.message}")
                runOnUiThread {
                    Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }.start()
    }


}
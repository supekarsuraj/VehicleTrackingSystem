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

class TermsConditionsActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var ivMenu: ImageView
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms_conditions)

        val tvHeaderTitle = findViewById<TextView>(R.id.tvHeaderTitle)
        tvHeaderTitle.text = "SVP InfoTech"

        drawerLayout = findViewById(R.id.drawer_layout)
        ivMenu = findViewById(R.id.ivMenu)
        navigationView = findViewById(R.id.navigation_view)

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
                    startActivity(Intent(this, AboutUsActivity::class.java))
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_terms_conditions -> {
                    startActivity(Intent(this, TermsConditionsActivity::class.java))
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_privacy_policy, R.id.nav_terms_conditions -> {
                    drawerLayout.closeDrawers()
                    true
                }
                else -> false
            }
        }

        val tvContent = findViewById<TextView>(R.id.tvTermsConditions)
        val policyText = """
            Privacy Policy and Terms Conditions

            Privacy Policy
            This privacy statement describes how SVP InfoTech collects and uses the personal information you provide on our website: blling.svpinfotech.com. It also describes the choices available to you regarding our use of your personal information and how you can access and update this information.

            Collection and Use Of Personal Information
            We collect the following personal information from you:
            Contact Information such as name, email address, mailing address and phone number. Billing Information such as payment mode details and billing address (we seek payment mode and billing details from customer for verifying his payment detail to deliver the service). If you are registering on behalf of your organization, your company's name, mailing address, and other company information, as deemed necessary for the purpose of providing services.

            As is true of most websites, we automatically gather information about your computer such as your IP address, browser type, referring/exit pages, and operating system. We use the information we collect to:
            Respond to customer service & offer requests. Administer your account. Improve our website and marketing efforts.

            Information Sharing
            We will share your personal information with third parties only in the ways that are described in this privacy statement. We do not sell your personal information to third parties.

            Refund Policy
            If you place order twice then we can refund one transaction. Remaining have no refund.

            Possible Reasons for cancellation / Refund Amount / Explanation:
            - Order Cancellation After Making the Payment:
              * Within 24 Hours: Up to 90% refund.
              * Within 2-3 Days: Up to 50% refund.
              * After 3 Days: No Refund.

            - Other Reasons:
              * By Mistake Paid Extra: 100% refund (minus transaction charges)
              * Did Not Like Design: No Refund
              * Work Delay: Up to 50% (case-by-case)
              * Work Rejection: 0% (rework offered)
              * Technical Glitches: 0%

            For any type of refund, please email rk.svpinfotech@gmail.com with a request letter on your letterhead along with PAN Card, Aadhar Card, Cancelled Cheque. Refund will be done within 45 working days after approval.

            Updates to these Policies:
            SVP InfoTech retains the right to modify provisions of cancellation or refund policy without giving prior notice.
        """.trimIndent()

        tvContent.text = policyText
    }
}

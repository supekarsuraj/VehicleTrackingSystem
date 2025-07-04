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

class AboutUsActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var ivMenu: ImageView
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        val tvAboutUs = findViewById<TextView>(R.id.tvAboutUs)
        drawerLayout = findViewById(R.id.drawer_layout)
        ivMenu = findViewById(R.id.ivMenu)
        navigationView = findViewById(R.id.navigation_view)

        val aboutText = """
            Company Profile

            SVP InfoTech came into existence on 1st January 2009 with a mission to cater high quality software solutions for various businesses with cost effectiveness and high quality. Since day one, the company has been known for its professionalism and expertise in giving tailor made solutions to its clients coming from different walks of life and backgrounds. The company specializes in web development, website design, eCommerce solutions, Web Application, Custom Development, Email marketing and Bulk SMS. SVP InfoTech is known with ample amount of flexibility. We never allow you pay more or give less attention than you really deserve. Thus meeting all the requirements as set by clients.

            Our Philosophy

            SVP InfoTech believes in only one mantra – giving competitive software solutions to our clients surpassing all the expectations of our clients. Thus complete customer satisfaction is our mission, which we often accomplish and invariably it extends to customer delight. This makes SVP InfoTech a public oriented company wherein our team works business to business and person to person.

            What We Do?

            We offer highly professional web solutions including website design, web development, web application development, e-commerce applications, e-commerce web development, search engine optimization, Digital Marketing, Bulk SMS Services and Email Marketing to name a few. We also undertake revamping of the current websites along with designing fresh and new sites in different platforms using all the modern day technologies used in e-commerce platforms and other web portals and applications. This makes us a customer-centric and focused Indian software company in the IT domain.

            How We Work?

            The company though incepted in 2009, has in terms of expertise and professionalism surpassed all expectations of its clients. Starting with a modest team to a competitively sizeable team of highly skilled software professionals, web designers and developers, they accomplish the following functions:

            - Basic & Advanced Web Design
            - Creative & innovative web designers
            - Highly responsible project managers
            - Experienced Quality software testers
            - Professional SEO analysts & digital media marketers

            With experience and expertise, the design and development teams at SVP InfoTech have catered highly competitive software solutions to clients from a wide range of backgrounds and specializations not just in India but also to our clients based in other countries in the west.
        """.trimIndent()

        tvAboutUs.text = aboutText

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
    }
}

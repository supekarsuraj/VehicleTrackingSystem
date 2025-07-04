
# 🚗 Vehicle Tracking System 📍

This is a **Vehicle Tracking System Android App** built in **Kotlin**, designed to help fleet owners and drivers track and manage vehicle details easily.  
It includes user login, vehicle document management, and a navigation drawer for simple access.

## ✨ Features

✅ **Login System**  
- Secure login with username & password
- Password show/hide toggle

✅ **Dashboard / Home Screen**  
- Fetch vehicle list via API
- Display vehicle details: Vehicle No, Name, Driver ID, User ID
- Welcome message with user’s name
- Navigation drawer with Home, About Us, Privacy Policy, Terms & Conditions
- Logout functionality with confirmation dialog

✅ **Vehicle Documents**  
- View Insurance, PUC, Fitness Certificate, Permit, Tax documents
- Zoom any document image with pinch gestures (PhotoView)

---

## 📂 Project Structure
├─ java/com.example.vehicletrackingsystem/
│ ├─ MainActivity.kt # Login screen
│ ├─ HomeActivity.kt # Dashboard with navigation
│ ├─ uiDesign/
│ │ ├─ VehicleDocumentActivity.kt # View vehicle documents
│ │ ├─ AboutUsActivity.kt
│ │ ├─ TermsConditionsActivity.kt
│ │ ├─ ...
│ └─ ...
├─ res/layout/
│ ├─ activity_main.xml # Login layout
│ ├─ activity_home.xml # Dashboard layout
│ ├─ activity_vehicle_document.xml
│ ├─ header.xml # Common header with menu and logout
│ ├─ ...
├─ res/drawable/ # Icons & logo
├─ res/menu/ # Drawer menu XML
├─ AndroidManifest.xml

## ⚙️ Technologies Used

- 🧩 Kotlin
- 📐 XML for UI layouts
- 🧭 Navigation Drawer (`NavigationView`)
- 🪟 DrawerLayout & CardView
- 🔌 OkHttp for API calls
- 🖼️ PhotoView (for image zoom)
- ✅ Modern Android development patterns

## 🔗 API Used

- **Verify User:**  

## ⚙️ Technologies Used

- 🧩 Kotlin
- 📐 XML for UI layouts
- 🧭 Navigation Drawer (`NavigationView`)
- 🪟 DrawerLayout & CardView
- 🔌 OkHttp for API calls
- 🖼️ PhotoView (for image zoom)
- ✅ Modern Android development patterns


## 🔗 API Used

- **Verify User:**  

## 🗂️ How To Run

1️⃣ **Clone the Repository**
```bash
git clone https://github.com/supekarsuraj/VehicleTrackingSystem.git
dependencies {
    implementation 'com.github.chrisbanes:PhotoView:2.3.0'
}
repositories {
    maven { url 'https://jitpack.io' }
}


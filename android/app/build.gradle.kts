plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.ultrasourov.ai"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.ultrasourov.ai"
        minSdk = 26
        targetSdk = 34 // Tailored for Tecno Spark 40 Pro (Android 14 / HiOS 14)
        versionCode = 1
        versionName = "1.0.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)

    // Networking for Gemini API
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.okhttp)

    // CameraX for Vision Solver
    implementation(libs.camera.core)
    implementation(libs.camera.camera2)
}

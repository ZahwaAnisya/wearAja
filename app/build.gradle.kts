plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.wearos"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.wearos"
        minSdk = 30
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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

    sourceSets {
        getByName("main") {
            manifest.srcFile("src/main/AndroidManifest.xml")
        }
    }
}

dependencies {
    // Wear OS Compose Dependencies
    implementation(platform("androidx.compose:compose-bom:2024.02.00"))
    implementation("androidx.wear.compose:compose-material:1.6.0")
    debugImplementation("androidx.compose.ui:ui-tooling:1.6.0")

    // Compose Dependencies
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.foundation)
    implementation(libs.compose.runtime)
    implementation(libs.compose.material) // Material untuk Wear OS
    implementation(libs.compose.material.icons.extended)
    implementation(libs.activity.compose)

    // Tooling dan Preview
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.4") // Pastikan versi ini kompatibel
    debugImplementation("androidx.compose.ui:ui-tooling:1.5.4")    // Pastikan versi ini kompatibel
    implementation(libs.wear.tooling.preview)

    // Wear OS SDK & Google Services
    implementation(libs.play.services.wearable)
    implementation(libs.core.splashscreen)

    // Wear OS Tiles & Horologist
    implementation(libs.tiles)
    implementation(libs.tiles.material)
    implementation(libs.tiles.tooling.preview)
    implementation(libs.horologist.compose.tools)
    implementation(libs.horologist.tiles)

    // Watchface Dependencies
    implementation(libs.watchface.complications.data.source.ktx)

    // Testing Dependencies
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.test.manifest)
    debugImplementation(libs.tiles.tooling)
}

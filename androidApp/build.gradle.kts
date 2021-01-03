plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
}
group = "in.techrova.kmmapplication"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}
dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.2.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.2")
}
android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "in.techrova.kmmapplication.androidApp"
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        viewBinding = true
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}
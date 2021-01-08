import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("kotlin-android")
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
    //implementation ("org.jetbrains.kotlinx:kotlinx-serialization-runtime:1.0-M1-1.4.0-rc")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")
    implementation ("com.github.bumptech.glide:glide:4.11.0")
    kapt ("com.github.bumptech.glide:compiler:4.11.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.2")
    implementation ("androidx.fragment:fragment-ktx:1.2.5")
    implementation ("androidx.activity:activity-ktx:1.1.0")
    implementation ("com.airbnb.android:epoxy:4.1.0")
    implementation ("com.airbnb.android:epoxy-databinding:4.1.0")
    kapt ("com.airbnb.android:epoxy-processor:4.1.0")
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
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
        dataBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        val options = this as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        options.jvmTarget = "1.8"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}
buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.20")
        classpath("com.android.tools.build:gradle:4.1.0")
        //classpath("io.ktor:ktor-client-core-jvm:1.5.0")

    }
}
group = "in.techrova.kmmapplication"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

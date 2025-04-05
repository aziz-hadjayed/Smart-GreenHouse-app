



plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.SmartGreenhouse"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.SmartGreenhouse"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.database)

    // Ajout de MPAndroidChart
    implementation ("com.google.firebase:firebase-database:20.3.0")
    implementation ("com.google.firebase:firebase-auth:22.1.1")
    implementation(libs.recyclerview)
    implementation ("androidx.recyclerview:recyclerview:1.3.1")
    implementation(libs.play.services.maps)



    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)

    androidTestImplementation(libs.espresso.core)

}
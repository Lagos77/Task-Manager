plugins {
    id ("org.jetbrains.kotlin.android")
    id ("com.android.library")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
}

android {
    namespace = "com.app.data"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk  = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = AppConfig.jvmTaget
        }
    }
}

dependencies {

    implementation(project(":domain"))

    implementation(platform("com.google.firebase:firebase-bom:26.4.0"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-firestore:24.4.4")
    implementation ("com.google.firebase:firebase-auth-ktx")
    implementation ("com.google.android.gms:play-services-auth:20.3.0")
    implementation("com.google.firebase:firebase-firestore-ktx:24.4.1")

    //Hilt
    hilt()

    //Room
    room()

}

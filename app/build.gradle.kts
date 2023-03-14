plugins {
    id("kotlin-kapt")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

kapt {
    correctErrorTypes = true
}

android {
    namespace = ("com.app.todoapp")
    compileSdk = AppConfig.compileSdk

    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        applicationId = ("com.app.todoapp")
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
        vectorDrawables.useSupportLibrary = true
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
    kotlinOptions {
        jvmTarget = AppConfig.jvmTaget
    }
}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(Dependency.ktxCore)
    implementation(Dependency.appCompat)
    implementation(Dependency.ktxCore)
    implementation(Dependency.constraintLayout)
    testImplementation(Dependency.junit)
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Hilt
    hilt()
}
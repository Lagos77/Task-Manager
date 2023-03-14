import org.gradle.api.artifacts.dsl.DependencyHandler

object AppConfig {
    const val compileSdk = 33
    const val minSdk = 24
    const val targetSdk = 33
    const val versionCode = 1
    const val versionName = "1.0"
    const val jvmTaget = "1.8"

    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Versions {
    const val appCompatVersion = "1.6.0"
    const val jUnitVersion = "4.13.2"
    const val ktxCoreVersion = "1.7.0"
    const val materialVersion = "1.8.0"
    const val constraintLayoutVersion = "2.1.4"

    const val activityViewModelVersion = "1.6.1"
    const val fragmentViewModelVersion = "1.5.4"
    const val daggerHiltVersion = "2.44"
    const val daggerHiltCompilerVersion = "2.44"
}

object Dependency {
    const val junit = "junit:junit:${Versions.jUnitVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktxCoreVersion}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"

    const val Hilt = "com.google.dagger:hilt-android:${Versions.daggerHiltVersion}"
    const val HiltCompile = "com.google.dagger:hilt-compiler:${Versions.daggerHiltCompilerVersion}"
    const val activityViewModel =
        "androidx.activity:activity-ktx:${Versions.activityViewModelVersion}"
    const val fragmentViewModel =
        "androidx.fragment:fragment-ktx:${Versions.fragmentViewModelVersion}"
}

fun DependencyHandler.hilt() {
    implementation(Dependency.Hilt)
    kapt(Dependency.HiltCompile)
    kapt(Dependency.activityViewModel)
    kapt(Dependency.fragmentViewModel)
}

private fun DependencyHandler.implementation(name: String) {
    add("implementation", name)
}

private fun DependencyHandler.kapt(name: String) {
    add("kapt", name)
}
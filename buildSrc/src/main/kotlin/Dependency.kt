import org.gradle.api.artifacts.dsl.DependencyHandler

object AppConfig {
    const val compileSdk = 33
    const val minSdk = 28
    const val targetSdk = 32
    const val versionCode = 1
    const val versionName = "1.0"
    const val jvmTaget = "1.8"

    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Versions {
    const val jUnitVersion = "4.13.2"
    const val ktxCoreVersion = "1.7.0"

    const val activityViewModelVersion = "1.6.1"
    const val fragmentViewModelVersion = "1.5.4"
    const val daggerHiltVersion = "2.44"
    const val daggerHiltCompilerVersion = "2.44"

    const val splashScreenVersion = "1.0.0"
}

object Dependency {
    const val junit = "junit:junit:${Versions.jUnitVersion}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktxCoreVersion}"

    const val Hilt = "com.google.dagger:hilt-android:${Versions.daggerHiltVersion}"
    const val HiltCompile = "com.google.dagger:hilt-compiler:${Versions.daggerHiltCompilerVersion}"
    const val activityViewModel =
        "androidx.activity:activity-ktx:${Versions.activityViewModelVersion}"
    const val fragmentViewModel =
        "androidx.fragment:fragment-ktx:${Versions.fragmentViewModelVersion}"

    const val splashScreen = "androidx.core:core-splashscreen:${Versions.splashScreenVersion}"
}

fun DependencyHandler.hilt() {
    implementation(Dependency.Hilt)
    kapt(Dependency.HiltCompile)
    kapt(Dependency.activityViewModel)
    kapt(Dependency.fragmentViewModel)
}

fun DependencyHandler.splashScreen() {
    implementation(Dependency.splashScreen)
}

private fun DependencyHandler.implementation(name: String) {
    add("implementation", name)
}

private fun DependencyHandler.kapt(name: String) {
    add("kapt", name)
}
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

    const val componentUi = "2.5.2"
    const val componentFragment = "2.5.2"
    const val legacySupportVersion = "1.0.0"

    const val viewModelScopeVersion = "2.4.0"
    const val lifecycleScopeVersion = "2.4.0"
    const val liveData = "2.4.0"

    const val lifecycleViewModelVersion = "2.6.0-alpha02"
    const val lifecycleExtensionsVersion = "2.2.0"

    const val coroutinesVersion = "1.6.4"

    const val roomVersion = "2.5.0"
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

    const val componentUI = "androidx.navigation:navigation-ui-ktx:${Versions.componentUi}"
    const val componentFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.componentFragment}"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacySupportVersion}"

    const val viewModelScope =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModelScopeVersion}"
    const val lifecycleScope =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleScopeVersion}"

    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.liveData}"

    const val lifeCycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModelVersion}"
    const val lifecycleExtensionsVersion =
        "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensionsVersion}"

    const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutinesVersion}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val kotlinAnnotation = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val kotlinSymbol = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
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

fun DependencyHandler.navigationComponent() {
    implementation(Dependency.componentUI)
    implementation(Dependency.componentFragment)
    implementation(Dependency.legacySupport)
}

fun DependencyHandler.scopes() {
    implementation(Dependency.viewModelScope)
    implementation(Dependency.lifecycleScope)
    implementation(Dependency.liveData)

}

fun DependencyHandler.coroutines() {
    implementation(Dependency.coroutines)
}

fun DependencyHandler.lifecycle() {
    implementation(Dependency.lifeCycleViewModel)
    implementation(Dependency.lifecycleExtensionsVersion)
}

fun DependencyHandler.room() {
    implementation(Dependency.roomRuntime)
    annotationProcessor(Dependency.roomCompiler)
    kapt(Dependency.kotlinAnnotation)
    implementation(Dependency.roomKtx)
}

private fun DependencyHandler.implementation(name: String) {
    add("implementation", name)
}

private fun DependencyHandler.annotationProcessor(name: String){
    add("annotationProcessor", name)
}

private fun DependencyHandler.ksp(name: String) {
    add("ksp", name)
}
private fun DependencyHandler.kapt(name: String) {
    add("kapt", name)
}
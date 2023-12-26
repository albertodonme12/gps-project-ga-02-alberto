plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.devtools.ksp")
    id("org.jetbrains.dokka")
        id("org.sonarqube") version "4.4.1.3373"



}

sonar {
    properties {
        property("sonar.projectKey", "albertodonme12_gps-project-ga-02-alberto")
        property("sonar.organization", "albertodonme12")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}
android {
    namespace = "com.unex.asee.ga02.beergo"
    compileSdk = 34

    dataBinding {
        enable = true
    }

    defaultConfig {
        applicationId = "com.unex.asee.ga02.beergo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    viewBinding {
        enable = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }


}

dependencies{
    androidTestImplementation ("androidx.arch.core:core-testing:2.1.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    val room_version = "2.5.0"
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version") // To use Kotlin Symbol Processing (KSP)
    ksp("androidx.room:room-compiler:$room_version") // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version") // optional - Test helpers
    testImplementation("androidx.room:room-testing:$room_version")

    dependencies {

        implementation("com.google.code.gson:gson:2.10.1")
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
        implementation("com.github.bumptech.glide:glide:5.0.0-rc01")

        //Opción 1: probar llamadas a Retrofit - opción recomendada
        testImplementation("com.squareup.okhttp3:mockwebserver:4.2.1")


        val nav_version = "2.5.3"
        // Kotlin
        implementation("androidx.preference:preference:1.2.0")
        implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
        implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
        // Feature module Support
        implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")
        // Testing Navigation
        androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")
        // Jetpack Compose Integration
        implementation("androidx.navigation:navigation-compose:$nav_version")

    }


    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.annotation:annotation:1.6.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.5")
    implementation("androidx.preference:preference-ktx:1.2.0")
    implementation("androidx.preference:preference:1.2.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation ("androidx.test.espresso:espresso-contrib:3.5.1")
    androidTestImplementation("androidx.test:runner:1.5.1")
    androidTestImplementation("androidx.test:rules:1.5.0")
    debugImplementation("androidx.tracing:tracing:1.1.0")

    androidTestImplementation("org.mockito:mockito-core:3.+")
}
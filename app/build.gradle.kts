plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = ConfigData.appID
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = ConfigData.appID
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        jvmTarget = "1.8"
    }
    packagingOptions {
        resources.excludes.add("META-INF/*")
        pickFirst("**")
    }

//    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
//        kotlinOptions {
//            jvmTarget = "1.8"
//        }
//    }
}

dependencies {
    implementation (Dep.coreKtx)
    implementation (Dep.appCompat)
    implementation (Dep.material)
    implementation (Dep.constraint)
    implementation (Dep.hilt)
    implementation (Dep.hiltCompiler)
    implementation (Dep.retrofit)
    implementation (Dep.retrofitGson)
    implementation (Dep.gson)
    implementation (Dep.okHttp)
    implementation (Dep.activity)
    implementation (Dep.fragment)
    implementation (Dep.glide)

    annotationProcessor (Dep.glideCompiler)

    testImplementation (Dep.junit)

    androidTestImplementation (Dep.junitTesting)
    androidTestImplementation (Dep.espresso)
}

kapt {
    correctErrorTypes = true
}
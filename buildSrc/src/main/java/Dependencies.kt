object BuildPlugins {
//    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
//    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.coreKtx}" }
    val daggerHilt by lazy { "com.google.dagger:hilt-android-gradle-plugin:2.44" }

}

object Dep {
    val coreKtx by lazy { "androidx.core:core-ktx:1.7.0" }
    val appCompat by lazy { "androidx.appcompat:appcompat:1.6.0" }
    val material by lazy { "com.google.android.material:material:1.8.0" }
    val constraint by lazy { "androidx.constraintlayout:constraintlayout:2.1.4" }
    val junit by lazy { "junit:junit:4.13.2" }
    val junitTesting by lazy { "androidx.test.ext:junit:1.1.5" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:3.5.1" }
    val hilt by lazy { "com.google.dagger:hilt-android:2.42" }
    val hiltCompiler by lazy { "com.google.dagger:hilt-compiler:2.42" }
//    val hiltCompiler by lazy { "androidx.hilt:hilt-compiler:1.0.0" }
    val retrofit by lazy{ "com.squareup.retrofit2:retrofit:2.9.0" }
    val retrofitGson by lazy{ "com.squareup.retrofit2:converter-gson:2.9.0" }
    val gson by lazy{ "com.google.code.gson:gson:2.8.6" }
    val okHttp by lazy{ "com.squareup.okhttp3:okhttp:4.9.1" }
    val paging by lazy { "androidx.paging:paging-runtime-ktx:3.1.0-alpha03" }
    val activity by lazy { "androidx.activity:activity:1.6.0" }
    val fragment by lazy { "androidx.fragment:fragment-ktx:1.5.3" }
    val glide by lazy { "com.github.bumptech.glide:glide:4.14.2" }
    val glideCompiler by lazy { "com.github.bumptech.glide:compiler:4.14.2" }

}








/**
 * To define dependencies
 */
object Deps {
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val timber by lazy { "com.jakewharton.timber:timber:${Versions.timber}" }
    val materialDesign by lazy { "com.google.android.material:material:${Versions.material}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    val junit by lazy { "junit:junit:${Versions.jUnit}" }
    val core by lazy { "androidx.core:core-ktx:${Versions.CoreKtx}" }
    val activity by lazy { "androidx.activity:activity-ktx:${Versions.activ}" }
    val recyclerview by lazy { "androidx.recyclerview:recyclerview:${Versions.activ}" }
    val cardView by lazy { "androidx.cardview:cardview:${Versions.cardView}" }

    val roomCompiler by lazy { "androidx.room:room-compiler:${Versions.room}" }
    val roomRuntime by lazy { "androidx.room:room-runtime:${Versions.room}" }
    val roomKtx by lazy { "androidx.room:room-ktx:${Versions.room}" }

    val workRuntime by lazy { "androidx.work:work-runtime:${Versions.workVersion}" }
    val workRuntimeKtx by lazy { "androidx.work:work-runtime-ktx:${Versions.workVersion}" }


    val dataStore by lazy { "androidx.datastore:datastore-preferences:${Versions.dataStore}" }
    val dataStoreCore by lazy { "androidx.datastore:datastore-core:${Versions.dataStore}" }


    val protocJava by lazy { "io.grpc:protoc-gen-grpc-java:${Versions.protocJava}" }
    val protoc by lazy { "com.google.protobuf:protoc:${Versions.protoc}" }
    val protoBuf by lazy { "com.google.protobuf:protobuf-javalite:${Versions.proto}" }
    val protoLite by lazy { "com.google.protobuf:protobuf-lite:${Versions.protoLite}" }

    val multidex by lazy { "androidx.multidex:multidex:${Versions.multidex}" }


    val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navigationFragment}" }
    val navigationUi by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigationFragment}" }

}

/**
 * To define dependencies
 */
object JetPack {
    val ViewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Lifecycle}" }
    val lifecycleViewmodel by lazy { "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.Lifecycle}" }
    val lifecyclelivedata by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Lifecycle}" }
    val lifecycleRuntime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Lifecycle}" }
    val lifecycleCompiler by lazy { "androidx.lifecycle:lifecycle-compiler:${Versions.Lifecycle}" }
    val lifecycleCommon by lazy { "androidx.lifecycle:lifecycle-common-java8:${Versions.LifecycleCommon}" }
    val lifecycleSaveState by lazy { "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.LifecycleCommon}" }
    val lifecycleProcess by lazy { "androidx.lifecycle:lifecycle-process:${Versions.LifecycleCommon}" }
    val lifecycleExtension by lazy { "androidx.lifecycle:lifecycle-extensions:${Versions.LifecycleExtension}" }
}

/**
 * To define dependencies
 */
object Kotlin {
    val kotlinJdk by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.Kotlin}" }
    val Kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib:${Versions.Kotlin}" }
    val CoroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Coroutines}" }
    val CoroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Coroutines}" }

}

/**
 * To define dependencies
 */
object Network {
    val OkHttp by lazy { "com.squareup.okhttp3:okhttp:${Versions.OkHttp}" }
    val OkHttpInterceptorLogging by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.OkHttpInterceptorLogging}" }
    val Retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.Retrofit}" }
    val retrofitAdapter by lazy { "com.squareup.retrofit2:adapter-rxjava2:${Versions.Retrofit}" }
    val RetrofitConverterGson by lazy { "com.squareup.retrofit2:converter-gson:${Versions.RetrofitConverterGson}" }
    val Gson by lazy { "com.google.code.gson:gson:${Versions.Gson}" }

}

object Dagger {
    val Dagger by lazy { "com.google.dagger:dagger:${Versions.DAGGER}" }
    val DaggerAndroid by lazy { "com.google.dagger:dagger-android:${Versions.DAGGER}" }
    val DaggerSupport by lazy { "com.google.dagger:dagger-android-support:${Versions.DAGGER}" }
    val DaggerProcessor by lazy { "com.google.dagger:dagger-android-processor:${Versions.DAGGER}" }
    val DaggerCompiler by lazy {  "com.google.dagger:dagger-compiler:${Versions.DAGGER}" }
    val JavaxInject by lazy { "javax.inject:javax.inject:${Versions.INJECT}" }
}

object Glide {
    val glide by lazy { "com.github.bumptech.glide:glide:${Versions.glide}" }
    val glideAnnotationProcessor by lazy { "com.github.bumptech.glide:compiler:${Versions.glide}" }

}

object Reactive {
    val rxAndroid by lazy { "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}" }
    val rxJava by lazy { "io.reactivex.rxjava2:rxjava:${Versions.rxJava}" }
    val rxkotlin by lazy { "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}" }


}

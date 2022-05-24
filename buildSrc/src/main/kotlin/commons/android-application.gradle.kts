package commons

import ConfigData
import Deps
import implementation

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
//    id("com.google.protobuf")
    id("kotlin-android-extensions")
    id("androidx.navigation.safeargs.kotlin")

}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = ConfigData.APPLICATION_ID
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    sourceSets {
        getByName("main") {
            java.srcDir("src/main/kotlin")
        }
        getByName("test") {
            java.srcDir("src/test/kotlin")
        }
        getByName("androidTest") {
            java.srcDir("src/androidTest/kotlin")
        }
    }

    lint {
        lintConfig = rootProject.file(".lint/config.xml")
        checkAllWarnings = true
        warningsAsErrors = true
    }
    buildFeatures {
        dataBinding = true
    }
    configurations.all {
        resolutionStrategy.force("com.google.code.findbugs:jsr305:1.3.9")
    }
}

// Allow references to generated code for dagger
kapt {
    correctErrorTypes = true
}


dependencies {

    implementation(Deps.core)
    implementation(Dagger.DaggerAndroid)
    implementation(Dagger.Dagger)
    implementation(Dagger.DaggerSupport)
    kapt(Dagger.DaggerCompiler)
    kapt(Dagger.DaggerProcessor)
//    protobuf(Deps.protocJava)
//    protobuf(Deps.protoc)
//    protobuf(Deps.protoBuf)
//    protobuf(Deps.protoLite)
    implementation(Dagger.JavaxInject)
    implementation(Deps.appCompat)
    implementation(Deps.materialDesign)
    implementation(Deps.timber)
    implementation(Deps.constraintLayout)


    implementation(JetPack.ViewModel)
    implementation(JetPack.lifecyclelivedata)
    implementation(JetPack.lifecycleRuntime)
    implementation(JetPack.lifecycleCommon)
    implementation(JetPack.lifecycleSaveState)
    implementation(JetPack.lifecycleProcess)
    implementation(JetPack.lifecycleExtension)
    implementation(JetPack.lifecycleCompiler)
    implementation(JetPack.lifecycleViewmodel)


    implementation(Kotlin.Kotlin)
    implementation(Kotlin.kotlinJdk)
    implementation(Kotlin.CoroutinesCore)
    implementation(Kotlin.CoroutinesAndroid)

    implementation(Network.Retrofit)
    implementation(Network.OkHttp)
    implementation(Network.OkHttpInterceptorLogging)
    implementation(Network.retrofitAdapter)
    implementation(Network.RetrofitConverterGson)
    implementation(Network.Gson)

    implementation(Reactive.rxJava)
    implementation(Reactive.rxAndroid)
    implementation(Reactive.rxkotlin)

    kapt(Deps.roomCompiler)
    implementation(Deps.roomKtx)
    implementation(Deps.roomRuntime)


    implementation(Glide.glide)
    annotationProcessor(Glide.glideAnnotationProcessor)

    implementation(Deps.junit)
    implementation(Deps.multidex)
    implementation(Deps.dataStore)
    implementation(Deps.dataStoreCore)
    implementation(Deps.navigationFragment)
    implementation(Deps.navigationUi)
    implementation(Deps.workRuntime)
    implementation(Deps.workRuntimeKtx)
    implementation(Deps.recyclerview)
    implementation(Deps.activity)
}

import Deps
import Dagger
import JetPack
import Network
import Glide
import Reactive
import Kotlin

plugins {
    id(Plugins.ANDROID_APPLICATION)
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


    implementation ("com.google.protobuf:protobuf-java:3.0.0-beta-1")

}

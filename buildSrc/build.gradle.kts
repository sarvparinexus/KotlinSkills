repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
}

plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}



dependencies {
    implementation(GradlePlugin.kotlin)
    implementation(GradlePlugin.android)
//    implementation(GradlePlugin.spotLess)
    implementation(GradlePlugin.navigationSafe)
//    implementation(GradlePlugin.protoBuf)
}


object GradlePlugin {
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21"
    const val android = "com.android.tools.build:gradle:7.2.0"
//    const val spotLess = "com.diffplug.spotless:spotless-plugin-gradle:6.6.1"
    const val navigationSafe = "androidx.navigation:navigation-safe-args-gradle-plugin:2.3.1"
//    const val protoBuf = "com.google.protobuf:protobuf-gradle-plugin:0.8.13"
}
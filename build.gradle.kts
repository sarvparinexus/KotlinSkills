allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("gradle.plugin.com.google.protobuf:protobuf-gradle-plugin:0.7.0")
    }
}


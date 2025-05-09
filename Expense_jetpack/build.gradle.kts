// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript{
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.8.0-alpha05")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
    }
}
plugins {
    id("com.android.application") version "8.8.0-alpha05" apply false
    id("org.jetbrains.kotlin.android") version "2.0.0" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0" apply false
}
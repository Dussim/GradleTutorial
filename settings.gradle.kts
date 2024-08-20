pluginManagement {
    includeBuild("gradle/build-logic")
    repositories.gradlePluginPortal()
}

dependencyResolutionManagement {
    repositories.mavenCentral()
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "GradleTutorial"

includeBuild("groovy")
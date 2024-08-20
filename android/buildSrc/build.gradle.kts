plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

dependencies {
    implementation("com.android.tools.build:gradle:8.5.2")
}

gradlePlugin {
    plugins {
        register("android") {
            id = "android"
            description = "my preconfigured android plugin"
            implementationClass = "BinaryPlugin"
        }
    }
}
plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("irrelevant") {
            id = "extensions"
            implementationClass = "ExtensionsPlugin"
        }
    }
}
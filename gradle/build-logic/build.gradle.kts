plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("irrelevant") {
            id = "extensions"
            implementationClass = "ExtensionsPlugin"
        }

        register("irrelevant2") {
            id = "vicareBest"
            implementationClass = "VicareBestPlugin"
        }
    }
}
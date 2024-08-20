tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
}

println("### CONFIGURATION PHASE ### build.gradle.kts of project $name")

tasks.register("nothing") {
    println("This will be called third")

    doLast {
        println("### EXECUTION PHASE ###")
        println("This will be called fourth")
    }
}
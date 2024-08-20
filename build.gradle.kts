plugins {
    id("extensions")
}

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

extension1 {
    println("configuring extension1 $this, look at the class $javaClass\"")
    println("---\n")
}

extension2 {
    println("configuring extension2 $this, look at the class $javaClass\"")
    println("---\n")
}

extension3 {
    println("configuring extension3, look at the class $javaClass")
    println("---\n")
}

extension4 {
    println("configuring extension4  which had parameter passed to property ${d.get()}")
    println("---\n")
}
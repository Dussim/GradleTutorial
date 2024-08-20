// Agenda #2

println("### INIT PHASE ### init.gradle.kts")
println("This will be launched first for all the project separately")

allprojects {
    val name = name
    println("Configuring project $name from init script")
    tasks.register("taskFromInit") {
        println("task registered from INIT PHASE but configured in CONFIGURATION PHASE")
    }
}
println()
class BuildTypeContainer implements GroovyObject {
    def buildTypes = []

    BuildTypeContainer() {
        def debug = new BuildType("debug")
        debug.suffix = "debug"

        def release = new BuildType("release")
        release.suffix = "release"

        buildTypes.add(debug)
        buildTypes.add(release)
    }

    def methodMissing(String name, def closure) {
        def buildType = buildTypes.find { it.name == name }
        if (buildType != null) {
            println "Configure existing buildType = $buildType"
        } else {
            println "Unknown buildType, creating and configuring new one with name $name"
            buildType = new BuildType(name)
            buildTypes.add(buildType)
        }

        buildType.with closure.first() as Closure

        println "buildType after configuration = $buildType"
        println "------------------------------------------"
    }

    def debug(@DelegatesTo(BuildType) Closure configuration) {
        println "Configure predefined buildType debug via dedicated method"
        BuildType buildType = buildTypes.find { it.name == "debug" }

        buildType.with configuration

        println "buildType debug after configuration = $buildType"
        println "------------------------------------------"
    }
}

class BuildType {
    final String name
    String suffix

    BuildType(name) {
        this.name = name
    }

    @Override
    String toString() {
        return "$name-$suffix"
    }
}

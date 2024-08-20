import groovy.transform.Field

@Field private static final obj = new BuildTypeContainer()

def buildTypes(@DelegatesTo(BuildTypeContainer) Closure block) {
    obj.with block
}

buildTypes {
    debug {
        suffix = "beta"
    }

    release {
        suffix = "prod"
    }

    develop {
        suffix = "dev"
    }

    develop {
        suffix = "develop"
    }
}
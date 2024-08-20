import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.property
import javax.inject.Inject

class Extension1 {
    var a = 0
    var b = 0
    var c = false

    override fun toString(): String {
        return "Extension1(a=$a, b=$b, c=$c)"
    }
}

abstract class Extension2 @Inject constructor(val constructorParam: String) {
    var a = 0
    var b = 0

    override fun toString(): String {
        return "Extension2(constructorParam='$constructorParam', a=$a)"
    }
}

interface Extension3 {
    val a: Property<Int>
    val b: Property<Int>
    val c: Property<Boolean>
}

abstract class Extension4 @Inject constructor(constructorParam: String, objectFactory: ObjectFactory) {
    abstract val a: Property<Int>
    abstract val b: Property<Int>
    abstract val c: Property<Boolean>

    val d: Property<String> = objectFactory.property<String>()
        .convention(constructorParam)
}
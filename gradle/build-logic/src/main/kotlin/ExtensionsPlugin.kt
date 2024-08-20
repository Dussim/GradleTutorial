import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.the

class ExtensionsPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = target.run {
        extensions.add("extension1", Extension1()) // class is final but can be added
        extensions.create<Extension2>("extension2", "extension2Param")
        extensions.create<Extension3>("extension3")
        extensions.create<Extension4>("extension4", "extension4Param")

        the<Extension1>().apply {
            a = 2
        }
        the<Extension2>().apply {
            b = 1
        }
    }
}
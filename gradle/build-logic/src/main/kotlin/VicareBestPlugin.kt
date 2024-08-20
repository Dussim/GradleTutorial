import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.container
import org.gradle.kotlin.dsl.create

class VicareBestPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = target.run {
        extensions.create<VicareBestExtension>(
            "vicareBest",
            container<ClassDescription>()
        )
    }
}
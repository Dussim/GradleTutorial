import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.MapProperty
import org.gradle.api.provider.Property
import org.gradle.api.provider.SetProperty
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.gradle.kotlin.dsl.setProperty
import java.io.File
import javax.inject.Inject
import kotlin.io.path.createDirectories

abstract class VicareBestTask @Inject constructor(
    objectFactory: ObjectFactory,
) : DefaultTask() {
    private data class Clazz(
        val name: String,
        val type: ClassDescription.Type
    )

    @get:Input
    @get:Optional
    abstract val copies: Property<Int>

    @get:Input
    abstract val packageName: Property<String>

    @get:Input
    abstract val classNames: SetProperty<String>

    @get:Input
    abstract val classTypes: MapProperty<String, ClassDescription.Type>

    @get:OutputDirectory
    val outputDirectory: DirectoryProperty = objectFactory.directoryProperty()

    @TaskAction
    fun action() {
        val copies = copies.getOrElse(1)
        val packageName = packageName.get()
        val types = classTypes.filter { it.isNotEmpty() }.get()
        val names = classNames.filter { it.isNotEmpty() }.get()
        val output = outputDirectory.get().asFile

        if (!output.exists()) {
            output.toPath().createDirectories()
        }

        val classes = names.map {
            Clazz(it, types.getValue(it))
        }

        classes.forEach { classDescription ->
            repeat(copies) { copy ->
                val fileName = fileName(classDescription, copy)
                val fileContent = fileContents(classDescription, copy, packageName)

                File(output, fileName).apply {
                    if (!exists()) {
                        createNewFile()
                    }
                    writeText(fileContent)
                }
            }
        }
    }

    private fun fileContents(
        classDescription: Clazz,
        copy: Int,
        packageName: String
    ): String {
        val name = when (copy) {
            0 -> classDescription.name
            else -> "${classDescription.name}$copy"
        }
        val type = when (classDescription.type) {
            ClassDescription.Type.CLASS -> "class"
            ClassDescription.Type.DATA_OBJECT -> "data object"
        }

        return """
            $packageName
            
            $type $name
        """.trimIndent()
    }

    private fun fileName(classDescription: Clazz, copy: Int): String {
        val name = when (copy) {
            0 -> classDescription.name
            else -> "${classDescription.name}$copy"
        }

        return "$name.kt"
    }
}
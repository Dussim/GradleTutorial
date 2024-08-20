import org.gradle.api.Named
import org.gradle.api.provider.Property
import java.io.Serializable
import javax.inject.Inject

abstract class ClassDescription @Inject constructor(
    private val name: String
) : Named, Serializable {
    enum class Type : Serializable {
        CLASS, DATA_OBJECT
    }

    override fun getName(): String = name

    abstract val type: Property<Type>
}
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.model.ObjectFactory
import org.gradle.kotlin.dsl.property
import javax.inject.Inject

abstract class VicareBestExtension @Inject constructor(
    private val container: NamedDomainObjectContainer<ClassDescription>,
    objectFactory: ObjectFactory,
) : NamedDomainObjectContainer<ClassDescription> by container {

    val packageName = objectFactory.property<String>()
        .convention("xyz.dussim.gradle.tutorial")
}
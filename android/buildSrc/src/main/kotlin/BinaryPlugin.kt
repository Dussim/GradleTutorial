import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.the

class BinaryPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        // applying plugin manually
        pluginManager.apply(AppPlugin::class.java)

        // retrieving extension registered by this plugin. the<T> will get instance of it or throw
        val android = the<AppExtension>()
        android.apply {
            namespace = "xyz.dussim.gradle.tutorial.android"
            compileSdkVersion(34)

            defaultConfig {
                targetSdk = 34
                minSdk = 21

                applicationId = "xyz.dussim.gradle.tutorial.android"
            }
        }
    }
}
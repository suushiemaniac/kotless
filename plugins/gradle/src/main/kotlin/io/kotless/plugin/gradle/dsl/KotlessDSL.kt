package io.kotless.plugin.gradle.dsl

import org.gradle.api.Project
import java.io.Serializable

/** Kotless DSL root */
@KotlessDSLTag
class KotlessDSL(project: Project) : Serializable {
    internal var config: KotlessConfig = KotlessConfig(project)
    /** Declaration of Kotless configuration itself */
    @KotlessDSLTag
    fun config(configure: KotlessConfig.() -> Unit) {
        config = config.apply(configure)
    }

    internal lateinit var webapp: Webapp
    /** Configuration of Kotless Web application */
    @KotlessDSLTag
    fun webapp(configure: Webapp.() -> Unit) {
        webapp = Webapp().apply(configure)
    }

    internal val extensions: Extensions = Extensions()

    /** Extensions for Kotless deployment pipeline */
    @KotlessDSLTag
    fun extensions(configure: Extensions.() -> Unit) {
        extensions.configure()
    }
}

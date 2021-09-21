import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.exclude

fun DependencyHandlerScope.jackson() {
    "implementation"("io.github.justincase-jp.jackson-kotlin-commons:enumerated:$jacksonKotlinCommonsVersion")
    "implementation"("io.github.justincase-jp.jackson-kotlin-commons:textual:$jacksonKotlinCommonsVersion")
    "implementation"("io.github.justincase-jp.jackson-kotlin-commons:numerical:$jacksonKotlinCommonsVersion")
    "implementation"("io.github.justincase-jp.jackson-kotlin-commons:polymorphic:$jacksonKotlinCommonsVersion")
    "implementation"("io.github.justincase-jp.jackson-kotlin-commons:detached-cause:$jacksonKotlinCommonsVersion")
    "implementation"("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    "implementation"("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:$jacksonVersion")
    "implementation"("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
}

fun DependencyHandlerScope.ktor() {
    "implementation"("io.ktor:ktor-server-cio:$ktorVersion")
    "implementation"("io.ktor:ktor-server-core:$ktorVersion")
    "implementation"("io.ktor:ktor-jackson:$ktorVersion")
    "implementation"("io.ktor:ktor-auth:$ktorVersion")
    "testImplementation"("io.ktor:ktor-server-test-host:$ktorVersion") {
        exclude(group ="ch.qos.logback", module = "logback-classic")
    }
}

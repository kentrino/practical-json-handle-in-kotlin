import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.exclude
import org.gradle.kotlin.dsl.kotlin


fun DependencyHandlerScope.kotlinBom() {
    "implementation"(platform("org.jetbrains.kotlin:kotlin-bom"))
}

fun DependencyHandlerScope.kotlinStdlibJdk() {
    "implementation"(kotlin("stdlib"))
}

fun DependencyHandlerScope.coroutine() {
    "implementation"("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$kotlinCoroutinesVersion")
    "implementation"("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion")
}

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
    "implementation"("io.ktor:ktor-server-netty:$ktorVersion")
    "implementation"("io.ktor:ktor-server-core:$ktorVersion")
    "implementation"("io.ktor:ktor-jackson:$ktorVersion")
    "implementation"("io.ktor:ktor-auth:$ktorVersion")
    "testImplementation"("io.ktor:ktor-server-test-host:$ktorVersion") {
        exclude(group ="ch.qos.logback", module = "logback-classic")
    }
}

fun DependencyHandlerScope.logging() {
    "implementation"("org.slf4j:jul-to-slf4j:1.7.32")
    "runtimeOnly"("ch.qos.logback:logback-classic:1.2.6")
}

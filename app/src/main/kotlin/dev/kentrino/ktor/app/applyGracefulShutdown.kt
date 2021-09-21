package dev.kentrino.ktor.app

import io.ktor.server.engine.*
import java.util.concurrent.TimeUnit

fun ApplicationEngine.applyGracefulShutdown(enable: Boolean) = also {
    when (enable) {
        true -> {
            also { engine ->
                Runtime.getRuntime().addShutdownHook(Thread { engine.stop(6, 10, TimeUnit.SECONDS) })
            }
        }
        false -> {}
    }
}

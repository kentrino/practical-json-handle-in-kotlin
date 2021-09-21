package dev.kentrino.ktor.app

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import dev.kentrino.ktor.core.Currency
import dev.kentrino.ktor.core.Id
import dev.kentrino.ktor.core.randomId
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.jackson.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configure() {
    install(ContentNegotiation) {
        register(ContentType.Application.Json, JacksonConverter(jacksonObjectMapper().apply {
            configureJackson()
        }))
    }

    routing {
        route("/") {
            get {
                call.respond(HttpStatusCode.OK, IndexResponse(
                        3,
                        userId = randomId(),
                        currency = Currency.Yen(100000)
                ))
            }
        }
    }
}

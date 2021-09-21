package dev.kentrino.ktor.app

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
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
                call.respond(HttpStatusCode.OK, IndexResponse(3))
            }
        }
    }
}

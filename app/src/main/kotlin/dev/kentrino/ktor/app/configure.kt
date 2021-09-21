package dev.kentrino.ktor.app

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configure() {
    routing {
        route("/") {
            get {
                call.respond(HttpStatusCode.OK, "hello world")
            }
        }
    }
}

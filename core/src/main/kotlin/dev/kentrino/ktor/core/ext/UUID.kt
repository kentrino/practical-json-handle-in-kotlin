package dev.kentrino.ktor.core.ext

import java.util.*

val UUID.string: String
    get() {
        return this.toString()
    }

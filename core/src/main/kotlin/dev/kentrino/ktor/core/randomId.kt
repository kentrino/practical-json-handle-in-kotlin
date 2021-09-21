package dev.kentrino.ktor.core

import java.util.*


inline fun <reified T : Id> randomId(): T {
    val constructor = T::class.java.getConstructor(UUID::class.java)
    return constructor.newInstance(UUID.randomUUID()) as T
}

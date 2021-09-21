package dev.kentrino.ktor.core

import dev.kentrino.ktor.core.ext.string
import java.util.*


sealed class Id(val value: UUID) : StringConvertible, Comparable<Id> {
    override val string: String
        get() = value.string

    override fun equals(other: Any?): Boolean {
        if (javaClass == other?.javaClass) {
            return value == (other as Id).value
        }
        return false
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun compareTo(other: Id): Int {
        return when (val i = value.compareTo(other.value)) {
            0 -> if (javaClass == other.javaClass) {
                0
            } else {
                javaClass.name.compareTo(other.javaClass.name)
            }
            else -> i
        }
    }

    class UserId(value: UUID) : Id(value) {
        companion object : StringConvertibleDecoder<UserId> {
            override fun fromText(value: String) = UserId(value.toUUIDOrThrow())
        }
    }
}

fun String.toUUIDOrThrow(): UUID {
    return try {
        UUID.fromString(this)
    } catch (e: IllegalArgumentException) {
        throw e
    }
}

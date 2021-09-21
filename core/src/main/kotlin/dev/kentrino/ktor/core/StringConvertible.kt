package dev.kentrino.ktor.core

import jp.justincase.jackson.kotlin.textual.TextualDecoder
import jp.justincase.jackson.kotlin.textual.TextualEncoder

interface StringConvertible {
    val string: String

    companion object : TextualEncoder<StringConvertible> {
        override
        val StringConvertible.text
            get() = string
    }
}

interface StringConvertibleDecoder<T : StringConvertible> : TextualDecoder<T> {
    override
    fun fromNull() = throw NullPointerException()
}

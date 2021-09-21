package dev.kentrino.ktor.app

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.util.DefaultIndenter
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import jp.justincase.jackson.kotlin.numerical.codec.NumericalModule
import jp.justincase.jackson.kotlin.polymorphic.codec.PolymorphicModule
import jp.justincase.jackson.kotlin.textual.codec.TextualModule

fun ObjectMapper.configureJackson() {
    setDefaultPrettyPrinter(DefaultPrettyPrinter().apply {
        indentArraysWith(DefaultIndenter("  ", DefaultIndenter.SYS_LF))
        indentObjectsWith(DefaultIndenter("  ", DefaultIndenter.SYS_LF))
    })

    registerModule(TextualModule())
    registerModule(NumericalModule())
    registerModule(PolymorphicModule())
    registerModule(Jdk8Module())

    configure(SerializationFeature.INDENT_OUTPUT, true)
    configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    setSerializationInclusion(JsonInclude.Include.ALWAYS)
    // Avoid 0 initialization when a numeric property is absent.
    configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true)

    // propertyNamingStrategy = PropertyNamingStrategies.SNAKE_CASE
}

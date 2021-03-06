package dev.kentrino.ktor.app

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import dev.kentrino.ktor.core.Currency
import dev.kentrino.ktor.core.Id
import dev.kentrino.ktor.core.MusicCategory
import dev.kentrino.ktor.core.randomId
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.next

class IndexResponseTest : AnnotationSpec() {
    private val int = Arb.int(0, 100)

    private val objectMapper = jacksonObjectMapper().apply {
        configureJackson()
    }

    @Test
    fun serializeAndDeserialize() {
        val expectedNumber = int.next()
        val expectedUserId: Id.UserId = randomId()
        val response = IndexResponse(
                expectedNumber,
                userId = expectedUserId,
                musicCategory = MusicCategory.Rock,
                currency = Currency.Yen(10000),
        )
        val str = objectMapper.writeValueAsString(response)
        val obj = objectMapper.readValue<IndexResponse>(str)
        obj.nullableUserId shouldBe null
        obj.simpleNumber shouldBe expectedNumber
        obj.userId shouldBe expectedUserId
        obj.currency shouldBe Currency.Dollar(amount = 10000)
    }
}

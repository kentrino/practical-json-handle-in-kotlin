package dev.kentrino.ktor.app

import dev.kentrino.ktor.core.Id

data class IndexResponse(
    val simpleNumber: Int = 3,
    val userId: Id.UserId,
)

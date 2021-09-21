package dev.kentrino.ktor.app

import dev.kentrino.ktor.core.Id
import dev.kentrino.ktor.core.MusicCategory

data class IndexResponse(
    val simpleNumber: Int = 3,
    val userId: Id.UserId,
    val nullableUserId: Id.UserId? = null,
    val musicCategory: MusicCategory = MusicCategory.Rock,
)

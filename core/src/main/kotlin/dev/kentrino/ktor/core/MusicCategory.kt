package dev.kentrino.ktor.core

import jp.justincase.jackson.kotlin.enumerated.Enumerated
import jp.justincase.jackson.kotlin.enumerated.values
import jp.justincase.jackson.kotlin.textual.Textual

sealed class MusicCategory: StringConvertible {
    abstract val japaneseName: String

    override val string: String
        get() = japaneseName

    object Rock : MusicCategory() {
        override val japaneseName = "ロック"
    }

    object Jazz : MusicCategory() {
        override val japaneseName = "ジャズ"
    }

    object Metal : MusicCategory() {
        override val japaneseName = "メタル"
    }

    companion object : Enumerated<MusicCategory>, Textual<MusicCategory> {
        private val map: Map<String, MusicCategory>
            get() = MusicCategory.values.associateBy(MusicCategory::japaneseName)

        override fun fromText(value: String): MusicCategory {
            return map[value] ?: throw IllegalArgumentException()
        }

        override val MusicCategory.text: String
            get() = japaneseName
    }
}

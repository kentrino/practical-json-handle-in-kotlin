package dev.kentrino.ktor.core

import jp.justincase.jackson.kotlin.textual.Textual
import java.text.DecimalFormat

sealed class Currency {
    abstract val amount: Int

    data class Yen(override val amount: Int) : Currency()

    data class Dollar(override val amount: Int) : Currency()

    companion object :Textual<Currency> {
        override fun fromText(value: String): Currency {
            return when (value[0]) {
                '$'-> {
                    Dollar(value.drop(1).replace(",", "").toInt())
                }
                '¥'-> {
                    Dollar(value.drop(1).replace(",", "").toInt())
                }
                else -> throw IllegalArgumentException()
            }
        }

        override val Currency.text: String
            get() {
                val prefix =  when(this) {
                    is Yen -> {
                        "¥"
                    }
                    is Dollar -> {
                        "$"
                    }
                }
                return prefix + DecimalFormat("#,###").format(amount)
            }
    }
}

package dev.kentrino.ktor.app

import dev.kentrino.jsonassert.Library
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.booleans.shouldBeTrue

class LibraryTest : AnnotationSpec() {
    @Test
    fun someLibraryMethodReturnsTrue() {
        Library().someLibraryMethod().shouldBeTrue()
    }
}

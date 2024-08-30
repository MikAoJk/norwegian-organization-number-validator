package io.github.mikaojk.validator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ValidateNorwegianOrganizationNumberTest {

    @Test
    internal fun testShouldBeValidOrganizationNumber() {

        validNorwegianOrganizationNumbers().forEach {
            assertEquals(true, validNorwegianOrganizationNumber(it))
        }
    }

    @Test
    internal fun testShouldBeInvalidOrganizationNumber() {

        invalidNorwegianOrganizationNumbers().forEach {
            assertEquals(false, validNorwegianOrganizationNumber(it))
        }
    }

    private fun validNorwegianOrganizationNumbers(): List<String> {
        return listOf(
            "123456785",
            "135795313",
            "999263550",
            "999162681",
            "889640782",
            "998004993",
            "974791854",
            "921117795",
            "917755736",
            "995690217",
            "991013628",
            "993110469"
        )
    }

    private fun invalidNorwegianOrganizationNumbers(): List<String> {
        return listOf(
            "889640780",
            "135795310",
            "135795311",
            "135795312",
            "135795314",
            "135795315",
            "135795316",
            "135795317",
            "135795318",
            "135795319"
        )
    }
}

package io.github.mikaojk.validator

val weights: IntArray = intArrayOf(3, 2, 7, 6, 5, 4, 3, 2, 0)

fun validNorwegianOrganizationNumber(norwegianOrganizationNumber: String?): Boolean {
    if (norwegianOrganizationNumber == null || norwegianOrganizationNumber.length != 9) {
        return false
    }

    return validatenorwegianOrganizationNumberMod11(norwegianOrganizationNumber)

}

fun validatenorwegianOrganizationNumberMod11(norwegianOrganizationNumber: String): Boolean {

    var checksum = 0

    for (i in 0..8) {
        val currNum = (norwegianOrganizationNumber[i] - '0')
        checksum += currNum * weights[i]
    }

    checksum %= 11

    val checksumFinal = if (checksum == 0) 0 else 11 - checksum

    return checksumFinal != 10 &&
            norwegianOrganizationNumber[8] - '0' == checksumFinal
}


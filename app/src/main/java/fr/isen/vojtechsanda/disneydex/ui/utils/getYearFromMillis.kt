package fr.isen.vojtechsanda.disneydex.ui.utils

import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

fun getYearFromMillis(millis: Long): Int {
    val instant = Instant.ofEpochMilli(millis)

    val zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault())

    return zonedDateTime.year
}

package com.show.kclock


const val COMMON_YEAR_DAYS = 365
const val LEAP_YEAR_DAYS = 366
const val MILLIS_SECOND = 1000
const val SECOND_IN_MINUTE = 60
const val MILLIS_MINUTE = MILLIS_SECOND * SECOND_IN_MINUTE
const val MINUTE_IN_HOUR = 60
const val MILLIS_HOUR = MILLIS_MINUTE * MINUTE_IN_HOUR
const val HOUR_IN_DAY = 24
const val MILLIS_DAY = MILLIS_HOUR * HOUR_IN_DAY
const val MILLIS_WEEK = MILLIS_DAY * 7
internal fun Int.clamp(min: Int, max: Int): Int = if (this < min) min else if (this > max) max else this



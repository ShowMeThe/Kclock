package com.show.kclock


const val COMMON_YEAR_DAYS = 365
const val LEAP_YEAR_DAYS = 366
const val MILLIS_SECOND = 1000
const val MILLIS_MINUTE = MILLIS_SECOND * 60
const val MILLIS_HOUR = MILLIS_MINUTE * 60
const val MILLIS_DAY = MILLIS_HOUR * 24
const val MILLIS_WEEK = MILLIS_DAY * 7
internal fun Int.clamp(min: Int, max: Int): Int = if (this < min) min else if (this > max) max else this



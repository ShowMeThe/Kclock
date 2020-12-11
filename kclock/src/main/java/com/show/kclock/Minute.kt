package com.show.kclock

import java.io.Serializable

val Minute.timeInMillis get() = minute * MILLIS_MINUTE

val Minute.hours get() = minute / MINUTE_IN_HOUR


class Minute(val minute: Int) : Serializable {

    operator fun minus(other: Minute) = Minute(this.minute - other.minute)

    operator fun plus(other: Minute) = Minute(this.minute + other.minute)

}
package com.show.kclock

import java.io.Serializable


inline val Int.Hour get() = Hour(this)

inline val Hour.days get() = this.hour / HOUR_IN_DAY

inline val Hour.timeInMillis get() = this.hour * MILLIS_HOUR

inline val Hour.minute get() = Minute(hour * MINUTE_IN_HOUR)

inline class Hour(val hour: Int): Serializable {


    operator fun minus(other: Hour) = Hour(this.hour - other.hour)

    operator fun plus(other: Hour) = Hour(this.hour + other.hour)



}
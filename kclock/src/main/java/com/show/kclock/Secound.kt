package com.show.kclock

import java.io.Serializable


inline val Second.timeInMillis get() = this.second * MILLIS_SECOND

inline val Second.minutes get() = second / SECOND_IN_MINUTE

class Second(val second: Int) : Serializable  {

    operator fun minus(other: Second) = Hour(this.second - other.second)

    operator fun plus(other: Second) = Hour(this.second + other.second)

}
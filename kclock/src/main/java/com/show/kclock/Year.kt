package com.show.kclock

import java.io.Serializable
import kotlin.math.abs

/**
 *  com.show.kclock
 *  2020/10/11
 *  12:26
 *  ShowMeThe
 */
inline val Int.year get() = Year(this)

inline val Year.days
    get() = this.let {
        if (it.isLeap()) {
            COMMON_YEAR_DAYS
        } else {
            LEAP_YEAR_DAYS
        }
    }

infix fun Year.daysTo(other: Year) = this.let {
    val d = this - other
    var res = 0
    for(i in 0 until d){
        res += Year(it.year + i).days
    }
    res
}


inline class Year(val year: Int): Comparable<Year>, Serializable {


    fun isLeap() = (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)


    operator fun minus(other: Year) = abs(this.year - other.year)


    fun daysToZero() = COMMON_YEAR_DAYS * (year - 1) + howManyLeapToZero()

    private fun howManyLeapToZero():Int = howManyLeapToYear(Year(0))

    fun howManyLeapToYear(other: Int) = howManyLeapToYear(Year(other))

    fun howManyLeapToYear(other: Year):Int{
        val y = abs(year - other.year)
        var leapCount = 0
        for(i in 0 until y){
            if(Year(i).isLeap()) leapCount = leapCount.inc()
        }
        return leapCount
    }

    fun lastLeapYear(): Year {
        var y = year.dec()
        var res = Year(y)
        while (!res.isLeap()){
            y = y.dec()
            res = Year(y)
        }
        return res
    }

    fun nextLeapYear(): Year {
        var y = year.inc()
        var res = Year(y)
        while (!res.isLeap()){
            y = y.inc()
            res = Year(y)
        }
        return res
    }
    
    override fun toString(): String {
        return "{\"year\":$year}"
    }

    override fun compareTo(other: Year): Int = this.year.compareTo(other.year)

}
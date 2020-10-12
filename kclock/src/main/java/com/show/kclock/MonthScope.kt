package com.show.kclock

import java.io.Serializable
import kotlin.math.roundToInt

/**
 *  com.show.kclock
 *  2020/10/11
 *  12:26
 *  ShowMeThe
 */

inline val Int.months  get() = MonthScope(this)

inline val MonthScope.intYear  get() = (totalMonths.toDouble()/ 12).roundToInt()

inline val MonthScope.year  get() = (totalMonths.toDouble() / 12)

inline val MonthScope.contentYear get() = intYear to totalMonths % 12

fun MonthScope.contentYear(end:Int) = intYear >= end

class MonthScope(val totalMonths: Int) : Comparable<MonthScope>, Serializable{


    operator fun unaryMinus() = MonthScope(-totalMonths)
    operator fun unaryPlus() = MonthScope(+totalMonths)

    operator fun plus(other: MonthScope) = MonthScope(totalMonths + other.totalMonths)

    operator fun minus(other: MonthScope) = this + -other


    operator fun times(times: Double) = MonthScope((totalMonths * times).toInt())
    operator fun times(times: Int) = this * times.toDouble()
    operator fun times(times: Float) = this * times.toDouble()

    operator fun div(times: Double) = MonthScope((totalMonths / times).toInt())
    operator fun div(times: Int) = this / times.toDouble()
    operator fun div(times: Float) = this / times.toDouble()

    override fun compareTo(other: MonthScope): Int = this.totalMonths.compareTo(other.totalMonths)

    override fun toString(): String {
        return "{\"totalMonths\":$totalMonths}"
    }


    override fun hashCode(): Int {
        return totalMonths.hashCode()
    }

    override fun equals(other: Any?): Boolean {
       return if(other!=null && other is MonthScope){
           other.totalMonths == totalMonths
        }else{
            false
        }
    }
}








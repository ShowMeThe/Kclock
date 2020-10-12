package com.show.kclock

import java.io.Serializable

/**
 *  com.show.kclock
 *  2020/10/11
 *  12:26
 *  ShowMeThe
 */
val monthOfYears by lazy { arrayOf(MonthOfYear.January,
    MonthOfYear.February, MonthOfYear.March, MonthOfYear.April, MonthOfYear.May, MonthOfYear.June,
    MonthOfYear.July, MonthOfYear.August, MonthOfYear.September, MonthOfYear.October,
    MonthOfYear.November, MonthOfYear.December) }

enum class MonthOfYear(
    val index: Int,
    val commonDays: Int,
    val leapDays: Int = commonDays
): Serializable{
    January(1, commonDays = 31),
    February(2, commonDays = 28, leapDays = 29),
    March(3, commonDays = 31),
    April(4, commonDays = 30),
    May(5, commonDays = 31),
    June(6, commonDays = 30),
    July(7, commonDays = 31),
    August(8, commonDays = 31),
    September(9, commonDays = 30),
    October(10, commonDays = 31),
    November(11, commonDays = 30),
    December(12, commonDays = 31);


    fun days(leap: Boolean): Int = if (leap) commonDays else leapDays

    fun days(year: Year) :Int = if(year.isLeap()) leapDays else commonDays

    fun days(year: Int) :Int = if(Year(year).isLeap()) leapDays else commonDays

    companion object{

        operator fun invoke(index: Int) : MonthOfYear = values()[index - 1]


    }


    fun displayName() = this.toString()


    fun daysToNewYear(year: Int) :Int{
        var count = 0
        for(m in 0 until index){
            count += values()[m].days(year)
        }
        return count
    }

}
package com.show.kclock

import java.util.*

/**
 *  com.show.kclock.scope
 *  2020/10/11
 *  12:26
 *  ShowMeThe
 */
class DateTime(var millis: Long) {

    companion object {

        fun create(
            year: Int,
            month: Int,
            day: Int,
            hour: Int = 0,
            minute: Int = 0,
            second: Int = 0,
            milliseconds: Int = 0
        ): DateTime {
            val clampedMonth = month.clamp(1, 12)
            return createClamp(
                year = year,
                month = clampedMonth,
                day = day.clamp(1, MonthOfYear(month).days(year)),
                hour = hour.clamp(0, 23),
                minute = minute.clamp(0, 59),
                second = second.clamp(0, 59),
                milliseconds = milliseconds
            )
        }


        private fun createClamp(
            year: Int,
            month: Int,
            day: Int,
            hour: Int = 0,
            minute: Int = 0,
            second: Int = 0,
            milliseconds: Int = 0
        ) = DateTime(
            Calendar.getInstance().let {
                it.set(Calendar.YEAR,year)
                it.set(Calendar.MONTH,month - 1)
                it.set(Calendar.DAY_OF_MONTH,day)
                it.set(Calendar.HOUR_OF_DAY,hour)
                it.set(Calendar.MINUTE,minute)
                it.set(Calendar.SECOND,second)
                it.set(Calendar.MILLISECOND,milliseconds)
                it.timeInMillis
            }
        )



    }

}
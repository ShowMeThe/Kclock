package com.show.kclock

import java.util.*

/**
 *  com.show.kclock
 *  2020/10/11
 *  12:26
 *  ShowMeThe
 */

inline val Long.dateTime get() = DateTime(this)

inline val DateTime.year get() = this.year()

inline val DateTime.month get() = this.month()

inline val DateTime.realMonth get() = this.realMonth()

inline val DateTime.monthOfYear get() = this.monthOfYear()

inline val DateTime.day get() = this.day()

inline val DateTime.dayOfYear get() = this.dayOfYear()

inline val DateTime.hour get() = this.hour()

inline val DateTime.hourOfDay get() = this.hourOfDay()

inline val DateTime.minute get() = this.minute()

inline val DateTime.second get() = this.second()

inline val DateTime.milliSecond get() = this.milliSecond()


class DateTime(private val millis: Long) {

    val calendar by lazy {  Calendar.getInstance() }

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
                it.set(Calendar.YEAR, year)
                it.set(Calendar.MONTH, month - 1)
                it.set(Calendar.DAY_OF_MONTH, day)
                it.set(Calendar.HOUR_OF_DAY, hour)
                it.set(Calendar.MINUTE, minute)
                it.set(Calendar.SECOND, second)
                it.set(Calendar.MILLISECOND, milliseconds)
                it.timeInMillis
            }
        )

    }


    fun year() = calendar.let {
        it.timeInMillis = millis
        it[Calendar.YEAR]
    }

    fun month() = calendar.let {
        it.timeInMillis = millis
        it[Calendar.MONTH]
    }

    fun monthOfYear() = calendar.let {
        it.timeInMillis = millis
        monthOfYears[it[Calendar.MONTH]]
    }

    fun realMonth() = calendar.let {
        it.timeInMillis = millis
        it[Calendar.MONTH] + 1
    }

    fun day() = calendar.let {
        it.timeInMillis = millis
        it[Calendar.DAY_OF_MONTH]
    }

    fun dayOfYear() = calendar.let {
        it.timeInMillis = millis
        it[Calendar.DAY_OF_YEAR]
    }

    fun hour() = calendar.let {
        it.timeInMillis = millis
        it[Calendar.HOUR]
    }

    fun hourOfDay() = calendar.let {
        it.timeInMillis = millis
        it[Calendar.HOUR_OF_DAY]
    }

    fun minute() = calendar.let {
        it.timeInMillis = millis
        it[Calendar.MINUTE]
    }

    fun second() = calendar.let {
        it.timeInMillis = millis
        it[Calendar.SECOND]
    }

    fun milliSecond() = calendar.let {
        it.timeInMillis = millis
        it[Calendar.MILLISECOND]
    }



}
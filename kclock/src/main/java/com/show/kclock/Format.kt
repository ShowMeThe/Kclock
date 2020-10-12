package com.show.kclock

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

const val yyyy_MM_dd = "yyyy-MM-dd"
const val yyyy_MM_dd_HHmm = "yyyy-MM-dd HH:mm"
const val yyyy_MM_dd_HHmmss = "yyyy-MM-dd HH:mm:ss"
const val yyyyMMdd = "yyyy/MM/dd"
const val yyyyMMdd_HHmm = "yyyy/MM/dd HH:mm"
const val yyyyMMdd_HHmmss = "yyyy/MM/dd HH:mm:ss"

fun DateTime.format(formatStr:String = yyyy_MM_dd_HHmmss,locale: Locale = Locale.getDefault()) =
    SimpleDateFormat(formatStr,locale).format(calendar.time)


fun String.deFormat(formatStr:String = yyyy_MM_dd_HHmmss,locale: Locale = Locale.getDefault()):Long?{
    val stf = SimpleDateFormat(formatStr,locale)
    return try {
        stf.parse(this)?.time
    }catch (e:Exception){
        null
    }
}

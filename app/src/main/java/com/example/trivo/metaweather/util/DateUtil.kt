package com.example.trivo.metaweather.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {
    fun getTomorrow() : String {
        val date = Calendar.getInstance()
        date.add(Calendar.DAY_OF_YEAR, 1)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        return dateFormat.format(date.time)
    }
}
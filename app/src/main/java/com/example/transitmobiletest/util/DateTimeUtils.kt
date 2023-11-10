package com.example.transitmobiletest.util

import java.text.SimpleDateFormat

object DateTimeUtils {
    fun getFormattedDateTime(dateTime: String) : String{
        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm")
        return formatter.format(parser.parse(dateTime))
    }
}
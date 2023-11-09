package com.example.transitmobiletest.util

import com.example.transitmobiletest.R

object ColorUtils {
    fun getColorCodeFromCountryCode(countryCode: String) : Int{
        return when (countryCode) {
            "CA" -> R.color.country_color_ca
            "US" -> R.color.country_color_us
            "FR" -> R.color.country_color_fr
            "UK" -> R.color.country_color_uk
            "DE" -> R.color.country_color_de
            else -> R.color.country_color_other
        }
    }
}
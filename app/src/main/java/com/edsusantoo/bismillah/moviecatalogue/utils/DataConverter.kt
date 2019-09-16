package com.edsusantoo.bismillah.moviecatalogue.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DataConverter {
    companion object {
        @TypeConverter
        fun listToJsonString(value: List<String>): String {
            val gson = Gson()
            val type = object : TypeToken<List<String>>() {}.type
            return gson.toJson(value, type)
        }

        @TypeConverter
        fun jsonStringToList(value: String): List<String> {
            val gson = Gson()
            val type = object : TypeToken<List<String>>() {}.type
            return gson.fromJson(value, type)
        }
    }
}
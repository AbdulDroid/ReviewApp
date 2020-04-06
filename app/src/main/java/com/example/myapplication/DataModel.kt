package com.example.myapplication

import java.util.*

sealed class DataModel {
    data class TimeModel(val time: Date): DataModel()
    data class NewMessage(val view: String): DataModel()
    data class Messages(val message: Any): DataModel()
}
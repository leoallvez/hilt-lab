package io.github.leoallvez.hilt.database

import android.util.Log
import io.github.leoallvez.hilt.TAG
import javax.inject.Inject

class DatabaseAdapter @Inject constructor(var dataBaseService: DataBaseService) {
    fun log(message: String) {
        Log.d(TAG, "DatabaseAdapter $message")
        dataBaseService.log(message)
    }
}
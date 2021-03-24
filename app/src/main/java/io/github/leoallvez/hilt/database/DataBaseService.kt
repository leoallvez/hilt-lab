package io.github.leoallvez.hilt.database

import android.util.Log
import io.github.leoallvez.hilt.TAG
import javax.inject.Inject

class DataBaseService @Inject constructor() {

    fun log(message: String) {
        Log.d(TAG, "DatabaseService message: $message")
    }
}

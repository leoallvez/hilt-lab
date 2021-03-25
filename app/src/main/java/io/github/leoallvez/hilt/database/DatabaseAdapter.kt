package io.github.leoallvez.hilt.database

import android.content.Context
import android.util.Log
import dagger.hilt.android.qualifiers.ActivityContext
import io.github.leoallvez.hilt.TAG
import javax.inject.Inject

class DatabaseAdapter @Inject constructor(
        @ActivityContext private var context: Context,
        var dataBaseService: DataBaseService
        ) {

    fun log(message: String) {
        Log.d(TAG, "DatabaseAdapter $message")
        dataBaseService.log(message)
        Log.d(TAG, "Context is available: $context")
    }
}

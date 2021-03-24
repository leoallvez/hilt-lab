package io.github.leoallvez.hilt.network

import android.util.Log
import io.github.leoallvez.hilt.TAG
import javax.inject.Inject

class ResponseInterceptorImpl @Inject constructor() : Interceptor {
    override fun log(message: String) {
        Log.d(TAG, "This is a call response: $message")
    }
}
package io.github.leoallvez.hilt.network

import android.util.Log
import io.github.leoallvez.hilt.TAG
import javax.inject.Inject

class MyAppNetworkAdapter @Inject constructor() : NetworkAdapter {
    override fun log(message: String) {
        Log.d(TAG, "MyNetworkAdapter $message")
    }
}
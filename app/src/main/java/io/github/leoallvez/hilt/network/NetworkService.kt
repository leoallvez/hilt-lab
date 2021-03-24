package io.github.leoallvez.hilt.network

import android.util.Log
import io.github.leoallvez.hilt.TAG

class NetworkService private constructor(builder: Builder) {

    val protocol: String?
    val host: String?
    val path: String?
    val interceptor: Interceptor?

    init {
        this.protocol = builder.protocol
        this.host = builder.host
        this.path = builder.path
        this.interceptor = builder.interceptor
    }

    fun performNetWorkCall() {
        interceptor?.log("Call performed")
        Log.d(TAG, "Network call performed: $this")
    }

    class Builder {
        var protocol: String? = null
            private set
        var host: String? = null
            private set
        var path: String? = null
            private set
        var interceptor: Interceptor? = null
            private set

        fun protocol(protocol: String) = apply { this.protocol = protocol }
        fun host(host: String) = apply { this.host = host }
        fun path(path: String) = apply { this.path = path }
        fun interceptor(interceptor: Interceptor) = apply { this.interceptor = interceptor }
        fun build() = NetworkService(this)
    }
}

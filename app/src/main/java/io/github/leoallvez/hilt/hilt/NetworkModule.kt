package io.github.leoallvez.hilt.hilt

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import io.github.leoallvez.hilt.network.*

@Module
@InstallIn(ActivityComponent::class)
/**abstract*/ class NetworkModule {

//    @Binds
//    abstract fun bindNetworkAdapterImpl(networkAdapter: MyAppNetworkAdapter): NetworkAdapter

//    @Provides
//    fun provideNetworkService(): NetworkService {
//        return NetworkService.Builder()
//                .host("google.com")
//                .protocol("HTTPS")
//                .build()
//    }

    @CallInterceptor
    @Provides
    fun provideCallNetworkService(): NetworkService {
        return NetworkService.Builder()
                .host(host = "google.com")
                .protocol(protocol = "HTTPS")
                .interceptor(CallInterceptorImpl())
                .build()
    }

    @ResponseInterceptor
    @Provides
    fun provideResponseNetworkService(): NetworkService {
        return NetworkService.Builder()
                .host(host = "google.com")
                .protocol(protocol = "HTTPS")
                .interceptor(ResponseInterceptorImpl())
                .build()
    }
}

package io.github.leoallvez.hilt.hilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import io.github.leoallvez.hilt.network.MyAppNetworkAdapter
import io.github.leoallvez.hilt.network.NetworkAdapter

@Module
@InstallIn(ActivityComponent::class)
abstract class NetworkModule {

    @Binds
    abstract fun bindNetworkAdapterImpl(networkAdapter: MyAppNetworkAdapter): NetworkAdapter

}
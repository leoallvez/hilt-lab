package io.github.leoallvez.hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import io.github.leoallvez.hilt.database.DataBaseService
import io.github.leoallvez.hilt.database.DatabaseAdapter
import io.github.leoallvez.hilt.hilt.CallInterceptor
import io.github.leoallvez.hilt.hilt.ResponseInterceptor
import io.github.leoallvez.hilt.network.NetworkAdapter
import io.github.leoallvez.hilt.network.NetworkService
import io.github.leoallvez.hilt.stats.StatsViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var databaseAdapter: DatabaseAdapter
//    @Inject lateinit var networkAdapter: NetworkAdapter
    @CallInterceptor
    @Inject lateinit var networkService1: NetworkService

    @CallInterceptor
    @Inject lateinit var networkService2: NetworkService

    @CallInterceptor
    @Inject lateinit var networkService3: NetworkService

    private val statsViewModel: StatsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "DatabaseAdapter: $databaseAdapter")
        databaseAdapter.log("Hello Hilt")

//        networkAdapter.log("Interface binding")
        networkService1.performNetworkCall()
        networkService2.performNetworkCall()
        networkService3.performNetworkCall()

        statsViewModel.statsLiveData.observe(this, { stats ->
            Log.d(TAG, "New stat coming in: $stats")
        })
        statsViewModel.startStatsCollection()
    }

    @Inject
    fun directToDataBase(dataBaseService: DataBaseService) {
        dataBaseService.log("Method injection")
    }
}

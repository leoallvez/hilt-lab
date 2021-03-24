package io.github.leoallvez.hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import io.github.leoallvez.hilt.database.DataBaseService
import io.github.leoallvez.hilt.database.DatabaseAdapter
import io.github.leoallvez.hilt.network.NetworkAdapter
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var databaseAdapter: DatabaseAdapter
    @Inject lateinit var networkAdapter: NetworkAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "DatabaseAdapter: $databaseAdapter")
        databaseAdapter.log("Hello Hilt")

        networkAdapter.log("Interface binding")
    }

    @Inject
    fun directToDataBase(dataBaseService: DataBaseService) {
        dataBaseService.log("Method injection")
    }
}

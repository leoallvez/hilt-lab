package io.github.leoallvez.hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import io.github.leoallvez.hilt.database.DataBaseService
import io.github.leoallvez.hilt.database.DatabaseAdapter
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var databaseAdapter: DatabaseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "DatabaseAdapter: $databaseAdapter")
        databaseAdapter.log("Hello Hilt")
    }

    @Inject
    fun directToDataBase(dataBaseService: DataBaseService) {
        dataBaseService.log("Method injection")
    }
}
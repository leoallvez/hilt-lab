package io.github.leoallvez.hilt.stats

import android.os.Handler
import android.os.Looper
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StatsViewModel @ViewModelInject constructor() : ViewModel() {

    val statsLiveData = MutableLiveData<Int>()
    private var i = 0
    private lateinit var runnable: Runnable
    private val delayMillis = 500L

    fun startStatsCollection() = with(Handler(Looper.getMainLooper())) {
        runnable = Runnable {
            statsLiveData.value = ++i
            postDelayed(runnable, delayMillis)
        }
        postDelayed(runnable, delayMillis)
    }
}

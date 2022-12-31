package com.example.mvvmcounter

import android.app.Application
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmcounter.databinding.ActivityMainBinding

class MainViewModel(application: Application): AndroidViewModel(application) {

    val liveData = MutableLiveData<String>()

    init {
        startTimer()
    }

    fun startTimer(){

        object : CountDownTimer(10000, 1000){

            override fun onTick(p0: Long) {
                liveData.value = (p0/1000).toString()
            }

            override fun onFinish() {
                Toast.makeText(getApplication(), "Hello", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }
}
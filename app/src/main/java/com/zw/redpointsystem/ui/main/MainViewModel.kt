package com.zw.redpointsystem.ui.main

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val systemNum = MutableLiveData<Int>(0)
    val friendNum = MutableLiveData<Int>(0)
    val otherNum = MutableLiveData<Int>(0)

    val totalNum = MediatorLiveData<Int>()

    init {
        totalNum.addSource(systemNum){
            totalNum.value = systemNum.value!! + friendNum.value!! + otherNum.value!!
        }

        totalNum.addSource(friendNum){
            totalNum.value = systemNum.value!! + friendNum.value!! + otherNum.value!!
        }

        totalNum.addSource(otherNum){
            totalNum.value = systemNum.value!! + friendNum.value!! + otherNum.value!!
        }
    }

    fun clear(){
        systemNum.value = 0
        friendNum.value = 0
        otherNum.value = 0
    }
}
package com.example.testsuit.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testsuit.DataItem

class MainViewModel : ViewModel() {
    private val _countUser = MutableLiveData<List<DataItem>>()
    val countUser: LiveData<List<DataItem>> = _countUser
}
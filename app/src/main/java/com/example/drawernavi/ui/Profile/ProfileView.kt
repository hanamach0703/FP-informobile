package com.example.drawernavi.ui.Profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileView : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Welcome to My App"
    }
    val text: LiveData<String> = _text
}
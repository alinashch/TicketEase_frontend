package com.example.ticketease.MVVM.Person.Buyer.Catalog

import android.content.SharedPreferences
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ticketease.DataClasses.Catalog
import com.example.ticketease.DataClasses.Person.Cities
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel

class ViewModelCatalog @Inject constructor(
    private val prefs: SharedPreferences,
) : ViewModel() {
    var state = mutableStateOf(
        Gson().fromJson(prefs.getString("catalog",null)!!,
        Array<Catalog>::class.java).toList())
}
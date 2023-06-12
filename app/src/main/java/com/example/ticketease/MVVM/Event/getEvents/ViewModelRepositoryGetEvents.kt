package com.example.ticketease.MVVM.Event.getEvents

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ticketease.DataClasses.Catalog
import com.example.ticketease.DataClasses.PlaceTime.PlaceDTO
import com.example.ticketease.DataClasses.PlaceTime.PlaceType
import com.ticketEase.backend.DataClasses.Place.TypeOfPlace
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel

class ViewModelRepositoryGetEvents @Inject constructor(
    private val repository : getEventsRepository,

    private val prefs : SharedPreferences
) : ViewModel() {

    private val _list = MutableLiveData<List<PlaceDTO>>()
    val list: LiveData<List<PlaceDTO>>
        get() = _list

    init {
        viewModelScope.launch {
            _list.value = repository.get()
        }
    }
}
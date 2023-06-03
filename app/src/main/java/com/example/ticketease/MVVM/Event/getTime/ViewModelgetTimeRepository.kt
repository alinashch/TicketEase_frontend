package com.example.ticketease.MVVM.Event.getTime

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.example.ticketease.DataClasses.PlaceTime.PlaceType
import com.example.ticketease.MVVM.Event.getEvents.getEventsRepository
import com.ticketEase.backend.DataClasses.Place.TypeOfPlace
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel

class ViewModelgetTimeRepository @Inject constructor(
    private val repository : getTimeRepository,

    private val prefs : SharedPreferences
) : ViewModel() {
    var id  = prefs.getString("PlaceId",null)!!

    val get= runBlocking { repository.get(id) }

}
package com.example.ticketease.MVVM.Event.getEvents

import android.content.SharedPreferences
import com.example.ticketease.DataClasses.Catalog
import com.example.ticketease.DataClasses.Person.City
import com.example.ticketease.DataClasses.PlaceTime.PlaceDTO
import com.example.ticketease.DataClasses.PlaceTime.PlaceTimeDTO
import com.example.ticketease.DataClasses.PlaceTime.PlaceType
import com.example.ticketease.MVVM.Person.Buyer.BuyerRetrofitAPI
import com.ticketEase.backend.DataClasses.Place.TypeOfPlace
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class getEventsRepositoryImpl(private val api : BuyerRetrofitAPI,
                              private val prefs : SharedPreferences
):getEventsRepository {
    override suspend fun get(): List<PlaceDTO> = withContext(Dispatchers.IO) {
        //val type=PlaceType(TypeOfPlace.WITH, City(prefs.getString("city", "")!!).toString())

        val list = api.getPlace(City(prefs.getString("city", "")!!).toString())
        list
    }
}
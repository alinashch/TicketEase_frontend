package com.example.ticketease.MVVM.Event.getTime

import android.content.SharedPreferences
import com.example.ticketease.DataClasses.PlaceTime.PlaceDTO
import com.example.ticketease.DataClasses.PlaceTime.PlaceId
import com.example.ticketease.DataClasses.PlaceTime.PlaceTimeDTO
import com.example.ticketease.DataClasses.PlaceTime.PlaceType
import com.example.ticketease.MVVM.Event.getEvents.getEventsRepository
import com.example.ticketease.MVVM.Person.Buyer.BuyerRetrofitAPI

class getTimeRepositoryImpl (private val api : BuyerRetrofitAPI,
                             private val prefs : SharedPreferences
): getTimeRepository {
    override suspend fun get(place: String?): List<PlaceTimeDTO> {
        return api.getTime(place)
    }
}
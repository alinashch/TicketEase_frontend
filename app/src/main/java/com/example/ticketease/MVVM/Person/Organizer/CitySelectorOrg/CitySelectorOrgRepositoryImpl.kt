package com.example.ticketease.MVVM.Person.Organizer.CitySelectorOrg

import android.content.SharedPreferences
import com.example.ticketease.DataClasses.Person.BuyerUpdateCity
import com.example.ticketease.DataClasses.Person.OrganizerUpdateCity
import com.example.ticketease.MVVM.Person.Buyer.BuyerRetrofitAPI
import com.example.ticketease.MVVM.Person.Buyer.CitySelector.CitySelectorRepository

class CitySelectorOrgRepositoryImpl (
    private val api : BuyerRetrofitAPI,
    private val prefs : SharedPreferences
) : CitySelectorOrgRepository {
    override suspend fun update(organizer: OrganizerUpdateCity?): Boolean {

        return api.organizersUpdateCity(organizer)
    }
}
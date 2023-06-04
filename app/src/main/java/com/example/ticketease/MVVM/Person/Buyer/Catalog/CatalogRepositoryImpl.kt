package com.example.ticketease.MVVM.Person.Buyer.Catalog

import android.content.SharedPreferences
import com.example.ticketease.DataClasses.Catalog
import com.example.ticketease.DataClasses.Person.Cities
import com.example.ticketease.MVVM.Person.Buyer.BuyerRetrofitAPI

import kotlinx.coroutines.flow.Flow
import com.example.ticketease.DataClasses.Person.City

class CatalogRepositoryImpl  (
    private val api : BuyerRetrofitAPI,
    private val prefs : SharedPreferences
) : CatalogRepository {
    override suspend fun getAllEvents(): List<Catalog>  =
        api.getAllEvents(City(prefs.getString("city", "")!!))


}
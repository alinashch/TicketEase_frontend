package com.example.ticketease.MVVM.Person.Buyer.Catalog

import com.example.ticketease.DataClasses.Catalog
import com.example.ticketease.DataClasses.Person.Cities
import kotlinx.coroutines.flow.Flow

interface CatalogRepository {
    suspend fun getAllEvents(): List<Catalog>

}
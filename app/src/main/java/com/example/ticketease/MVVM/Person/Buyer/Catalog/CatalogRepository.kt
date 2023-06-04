package com.example.ticketease.MVVM.Person.Buyer.Catalog

import com.example.ticketease.DataClasses.Catalog
import com.example.ticketease.DataClasses.Person.Cities
import com.example.ticketease.MVVM.ApiResult
import kotlinx.coroutines.flow.Flow

interface CatalogRepository {
    suspend fun catalog(city: String?): Flow<ApiResult<List<Catalog>>>

}
package com.example.ticketease.MVVM.Person.Buyer.Catalog

import android.content.SharedPreferences
import com.example.ticketease.DataClasses.Catalog
import com.example.ticketease.DataClasses.Person.Cities
import com.example.ticketease.MVVM.ApiResult
import com.example.ticketease.MVVM.Person.Buyer.BuyerRetrofitAPI
import com.example.ticketease.MVVM.RequestUtils.requestFlow
import com.example.ticketease.mapToDomain
import kotlinx.coroutines.flow.Flow

class CatalogRepositoryImpl  (
    private val api : BuyerRetrofitAPI,
    private val prefs : SharedPreferences
) : CatalogRepository {
    override suspend fun catalog(ciy: String?): Flow<ApiResult<List<Catalog>>> {

        return requestFlow (
            { api.catalog(ciy)},  { value-> value?.mapToDomain()})

    }
}
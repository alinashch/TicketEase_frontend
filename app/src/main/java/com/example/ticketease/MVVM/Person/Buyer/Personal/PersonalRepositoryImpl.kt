package com.example.ticketease.MVVM.Person.Buyer.Personal
import android.content.SharedPreferences
import com.example.ticketease.DataClasses.Catalog
import com.example.ticketease.DataClasses.Person.Buyer
import com.example.ticketease.DataClasses.Person.BuyerResponse
import com.example.ticketease.DataClasses.Person.BuyerWithoutPswd
import com.example.ticketease.DataClasses.Person.City
import com.example.ticketease.MVVM.Person.Buyer.BuyerRetrofitAPI
import com.example.ticketease.MVVM.Person.Buyer.Register.RegistResult
import com.example.ticketease.MVVM.Person.Buyer.Register.RegisterRepository

class PersonalRepositoryImpl (
            private val api : BuyerRetrofitAPI,
            private val prefs : SharedPreferences
        ) : PersonalRepository {
    override suspend fun getByToken(buyer: BuyerResponse): BuyerWithoutPswd {
        return api.buyerByToken(buyer)
    }

    override suspend fun getAllEvents(): List<Catalog>  =
        api.getAllEvents(City(prefs.getString("city", "")!!))

}
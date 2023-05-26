package com.example.ticketease.MVVM.Person.Buyer.Personal

import android.annotation.SuppressLint
import android.content.SharedPreferences
import com.example.ticketease.DataClasses.Person.Buyer
import com.example.ticketease.DataClasses.Person.BuyerResponse
import com.example.ticketease.DataClasses.Person.BuyerWithoutPswd
import com.example.ticketease.MVVM.Person.Buyer.BuyerRetrofitAPI
import com.example.ticketease.MVVM.Person.Buyer.Register.RegistResult
import com.example.ticketease.MVVM.Person.Buyer.Register.RegisterRepository
import retrofit2.HttpException

class PersonalRepositoryImpl (
    private val api : BuyerRetrofitAPI,
    private val prefs : SharedPreferences
) : PersonalRepository {
    @SuppressLint("CommitPrefEdits")
    override suspend fun getByToken(buyer: BuyerResponse): PersonalResult<Unit> {
        return try{
            val response = api.buyerByToken(buyer)
            prefs.edit().putString("name", response.name)
            //response.name
            PersonalResult.Correct()
        }catch (e: HttpException){
                PersonalResult.Uncorrect()
        }
    }
}
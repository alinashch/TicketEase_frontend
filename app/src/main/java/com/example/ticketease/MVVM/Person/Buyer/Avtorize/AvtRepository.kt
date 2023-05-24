package com.example.ticketease.MVVM.Person.Buyer.Avtorize

import com.example.ticketease.DataClasses.Person.Buyer
import com.example.ticketease.DataClasses.Person.BuyerRequest

interface AvtRepository {
    suspend fun Avtorize(buyer: BuyerRequest) : AvtResult<Unit>

}
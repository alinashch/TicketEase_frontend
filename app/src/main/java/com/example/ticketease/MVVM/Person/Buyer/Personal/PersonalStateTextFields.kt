package com.example.ticketease.MVVM.Person.Buyer.Personal

import com.example.ticketease.MVVM.Person.Buyer.Register.RegisterStateTextFields

sealed class PersonalStateTextFields {

   // data class Token(val value: String):PersonalStateTextFields()
    object PersonalBuyer: PersonalStateTextFields()
}
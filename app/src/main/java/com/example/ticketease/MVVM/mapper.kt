package com.example.ticketease

import com.example.ticketease.DataClasses.Catalog
import com.example.ticketease.DataClasses.CatalogResponce

fun CatalogResponce.mapToDomain():List<Catalog>{
    var values: List<Catalog> = emptyList()
    for (u in this.values) {

        val searched = Catalog(
            u.name,
            u.price,
            u.location,
            u.date,

        )
        values = values + searched
    }
    return values
}
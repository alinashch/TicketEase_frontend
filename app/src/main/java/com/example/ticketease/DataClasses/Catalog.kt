package com.example.ticketease.DataClasses


import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.Serializable
import java.time.Instant


@Serializable
data class Catalog(
    @JsonProperty("name")
    val name : String,
    @JsonProperty("price")

    val price : Double,
    @JsonProperty("location")

    val location : String,
    @JsonProperty("date")

    @Serializable(with = DateSerializer::class)
    val date : Instant
    )

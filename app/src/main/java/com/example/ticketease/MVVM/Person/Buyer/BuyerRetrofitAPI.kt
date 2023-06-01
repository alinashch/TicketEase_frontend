package com.example.ticketease.MVVM.Person.Buyer

import com.example.ticketease.DataClasses.Event.EventDTO
import com.example.ticketease.DataClasses.Person.*
import com.example.ticketease.DataClasses.Ticket.TicketDTO
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface BuyerRetrofitAPI {
    @POST("/buyers/create")
   suspend fun postBuyer(@Body dataModel: Buyer?): BuyerWithoutPswd

    @POST("/buyers/signIn")
    suspend fun avtorize(@Body dataModel: BuyerRequest?): BuyerWithoutPswd

    @POST("/buyers/token")
   suspend  fun buyerByToken(@Body dataModel: BuyerResponse?):  BuyerWithoutPswd

    @POST("/events")
    suspend  fun selectAllEvents():  List<EventDTO>

    @POST ("/{eventId}")
    suspend fun selectByIDTicket(@Path("eventId") eventId: Long):List<TicketDTO>

    @POST("/organizers/create")
    suspend fun singInOrg(@Body dataModel: Organizer?): OrganizerWithoutPswd


    @PUT("/organizers/signIn")
    suspend fun avtorizeOrg(@Body dataModel: OrganizerRequest?): OrganizerWithoutPswd


    @POST("/organizers/token")
    suspend fun orgByToken(@Body dataModel: OrganizerResponse?):  OrganizerWithoutPswd
}
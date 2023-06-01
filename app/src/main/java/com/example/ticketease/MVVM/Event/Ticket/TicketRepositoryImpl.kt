package com.example.ticketease.MVVM.Event.Ticket

import com.example.ticketease.DataClasses.Ticket.TicketDTO
import com.example.ticketease.MVVM.Person.Buyer.BuyerRetrofitAPI

class TicketRepositoryImpl (private val api : BuyerRetrofitAPI
):TicketRepository{
    override suspend fun getAllTicket(eventID:Long): List<TicketDTO> {
        val response=api.selectByIDTicket(eventID)
        return response
    }
}


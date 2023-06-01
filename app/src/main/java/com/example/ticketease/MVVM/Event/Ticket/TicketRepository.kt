package com.example.ticketease.MVVM.Event.Ticket

import com.example.ticketease.DataClasses.Event.EventDTO
import com.example.ticketease.DataClasses.Ticket.TicketDTO

interface TicketRepository {
    suspend fun getAllTicket(eventId:Long):List<TicketDTO>

}


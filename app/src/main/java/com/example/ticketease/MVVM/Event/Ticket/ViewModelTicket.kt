package com.example.ticketease.MVVM.Event.Ticket

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.example.ticketease.MVVM.Event.Catalog.CatalogRepository
import com.example.ticketease.MVVM.Event.Catalog.ViewModelCatalog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class ViewModelTicket @Inject constructor(private val repository : TicketRepository
) : ViewModel() {
    var id:Long =0
    val tickets= runBlocking { repository.getAllTicket(id) }

}

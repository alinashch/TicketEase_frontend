package com.example.ticketease.MVVM.Person.Buyer

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.ticketease.MVVM.Event.Catalog.CatalogRepository
import com.example.ticketease.MVVM.Event.Catalog.CatalogRepositoryImpl
import com.example.ticketease.MVVM.Event.Ticket.TicketRepository
import com.example.ticketease.MVVM.Event.Ticket.TicketRepositoryImpl

import com.example.ticketease.MVVM.Person.Buyer.Avtorize.AvtRepository
import com.example.ticketease.MVVM.Person.Buyer.Avtorize.AvtRepositoryImpl
import com.example.ticketease.MVVM.Person.Buyer.Personal.PersonalRepository
import com.example.ticketease.MVVM.Person.Buyer.Register.RegisterRepository
import com.example.ticketease.MVVM.Person.Buyer.Register.RegisterRepositoryImpl
import com.example.ticketease.MVVM.Person.Buyer.Personal.PersonalRepositoryImpl
import com.example.ticketease.MVVM.Person.Organizer.Avtorize.AvtRepositoryOrg
import com.example.ticketease.MVVM.Person.Organizer.Avtorize.AvtRepositoryOrgImpl
import com.example.ticketease.MVVM.Person.Organizer.Personal.PersonalRepositoryOrg
import com.example.ticketease.MVVM.Person.Organizer.Personal.PersonalRepositoryOrgImpl
import com.example.ticketease.MVVM.Person.Organizer.Register.RegisterRepositoryOrg
import com.example.ticketease.MVVM.Person.Organizer.Register.RegisterRepositoryOrgImpl

import com.example.ticketease.MVVM.url
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.*
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun postDataRegisterUser() : BuyerRetrofitAPI {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(JacksonConverterFactory.create())
            .build().create()
    }

@Provides
@Singleton
fun provideSharedPref(app : Application) : SharedPreferences{
    return app.getSharedPreferences("prefs",MODE_PRIVATE)
}

    @Provides
    @Singleton
    fun provideRegisterRepository(api : BuyerRetrofitAPI,prefs : SharedPreferences) : RegisterRepository{
        return RegisterRepositoryImpl(api, prefs)
    }


    @Provides
    @Singleton
    fun provideAvtRepository(api : BuyerRetrofitAPI,prefs : SharedPreferences) : AvtRepository {
        return AvtRepositoryImpl(api, prefs)
    }


    @Provides
    @Singleton
    fun providePersonalRepository(api : BuyerRetrofitAPI,prefs : SharedPreferences) : PersonalRepository {
        return PersonalRepositoryImpl(api, prefs)
    }


    @Provides
    @Singleton
    fun provideCatalogRepository(api : BuyerRetrofitAPI) : CatalogRepository {
        return CatalogRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideTicketRepository(api : BuyerRetrofitAPI) : TicketRepository {
        return TicketRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideRegisterRepositoryOrg(api : BuyerRetrofitAPI,prefs : SharedPreferences) : RegisterRepositoryOrg {
        return RegisterRepositoryOrgImpl(api, prefs)
    }


    @Provides
    @Singleton
    fun provideAvtRepositoryOrg(api : BuyerRetrofitAPI,prefs : SharedPreferences) : AvtRepositoryOrg {
        return AvtRepositoryOrgImpl(api, prefs)
    }

    @Provides
    @Singleton
    fun providePersonalRepositoryOrg(api : BuyerRetrofitAPI,prefs : SharedPreferences) : PersonalRepositoryOrg {
        return PersonalRepositoryOrgImpl(api, prefs)
    }
}


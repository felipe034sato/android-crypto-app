package com.example.cryptotracker.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiFactory {

    fun createService(): BitcoinApi {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.mercadobitcoin.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(BitcoinApi::class.java)
    }
}
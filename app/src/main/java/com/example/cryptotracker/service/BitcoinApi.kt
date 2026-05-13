package com.example.cryptotracker.service

import com.example.cryptotracker.model.CoinResponse
import retrofit2.Response
import retrofit2.http.GET

interface BitcoinApi {

    @GET("api/BTC/ticker/")
    suspend fun getBitcoinData(): Response<CoinResponse>
}
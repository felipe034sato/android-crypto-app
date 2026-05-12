package com.example.cryptotracker.model

class CoinResponse(
    val ticker: CoinTicker
)

class CoinTicker(
    val high: String,
    val low: String,
    val last: String,
    val buy: String,
    val sell: String,
    val date: Long
)
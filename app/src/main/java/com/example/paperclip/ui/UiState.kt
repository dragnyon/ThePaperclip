package com.example.paperclip.ui

import java.math.BigDecimal
import java.math.BigInteger

data class UiState(
    //Paperclips
    val nbPaperclips: BigInteger = BigInteger("0"),

    //Business
    val price: BigDecimal = BigDecimal("0.0"),
    val costMarket: Double = 0.00,
    val funds: BigDecimal = BigDecimal("0.0"),
    val levelMarket: Int = 0,
    val demand: Int = 0,
    val unsoldClips: BigInteger = BigInteger("0"),
    val wires: BigInteger = BigInteger("0"),
    val clipMakerLevel: Int = 1
)

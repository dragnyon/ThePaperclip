package com.example.paperclip.ui

import java.math.BigDecimal
import java.math.BigInteger

data class UiState(
    //Paperclips
    val nbPaperclips: BigInteger = BigInteger("100"),

    //Business
    val price: BigDecimal = BigDecimal("0.20"),
    val costMarket: Double = 100.00,
    val funds: Double = 100000.00

)

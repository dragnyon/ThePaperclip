package com.example.paperclip.ui.views.stage1

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paperclip.domain.Business.Companion.lowerPrice
import com.example.paperclip.domain.Business.Companion.makePaperClips
import com.example.paperclip.domain.Business.Companion.raisePrice
import com.example.paperclip.domain.Business.Companion.sellClips
import com.example.paperclip.domain.Business.Companion.updateDemand
import com.example.paperclip.domain.Business.Companion.upgradeCostMarket
import com.example.paperclip.domain.Manufacturing.Companion.autoClipperProduction
import com.example.paperclip.domain.Manufacturing.Companion.buyWire
import com.example.paperclip.domain.Manufacturing.Companion.makeClipper
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.math.BigInteger

data class UiState(
    //Paperclips
    val nbPaperclips: BigInteger = BigInteger("0"),

    //Business
    val price: BigDecimal = BigDecimal("0.25"),
    val costMarket: Double = 100.0,
    val funds: BigDecimal = BigDecimal("0.0"),
    val levelMarket: Int = 1,
    val demand: Int = 0,
    val unsoldClips: BigInteger = BigInteger("0"),
    val clipMakerLevel: Int = 0,
    val clipperCost: Double = 5.0,
    val wires: BigInteger = BigInteger("1000"),
    val wireCost: Double = 15.0,
    val wireBasePrice: Double = 15.0,
    val wirePriceTimer: Int = 0,
    val wireSupply: Int = 1000,
)


class Stage1ViewModel : ViewModel() {

    val uiState: MutableState<UiState> = mutableStateOf(UiState())

    init {
        onUiEvent(OnEvent.OnInit)
        test()
    }

    fun onUiEvent(uiEvent: OnEvent) {
        when (uiEvent) {
            is OnEvent.OnInit -> {
                uiState.value = UiState()
            }

            is OnEvent.OnGenerateClick -> {
                uiState.makePaperClips()
            }


            is OnEvent.RaisePrice -> {
                uiState.raisePrice()
            }


            is OnEvent.LowerPrice -> {
                uiState.lowerPrice()

            }

            is OnEvent.UpgradeMarket -> {
                uiState.upgradeCostMarket()

            }

            is OnEvent.MakeClipper -> {
                uiState.makeClipper()
            }

            is OnEvent.BuyWire -> {
                uiState.buyWire()
            }
        }
    }


    private fun test() {
        viewModelScope.launch {
            while (isActive) {
                // Appeler votre fonction ici
                uiState.updateDemand()

                // Attendre 100 millisecondes
                delay(100)
            }
        }

        // Coroutine pour la production de trombones
        viewModelScope.launch {
            while (isActive) {
                uiState.autoClipperProduction() // Appelle la fonction de production
                delay(1000) // Produit toutes les 100ms
            }
        }

        // Coroutine pour la vente de trombones
        viewModelScope.launch {
            while (isActive) {
                uiState.sellClips() // Appelle la fonction de vente
                delay(1000) // Vend toutes les 1 seconde
            }
        }
    }
}

sealed class OnEvent {
    data object OnInit : OnEvent()
    data object OnGenerateClick : OnEvent()

    //Business
    data object RaisePrice : OnEvent()
    data object LowerPrice : OnEvent()
    data object UpgradeMarket : OnEvent()
    data object MakeClipper : OnEvent()
    data object BuyWire : OnEvent()
}
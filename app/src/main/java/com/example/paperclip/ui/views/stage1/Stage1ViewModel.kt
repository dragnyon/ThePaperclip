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
import java.math.BigInteger

data class UiState(
    //Paperclips
    val nbPaperclips: BigInteger = BigInteger("5"),

    //Business
    val price: Double = 0.25,
    val costMarket: Double = 100.0,
    val funds: Double = 100000000.00,
    val levelMarket: Int = 1,
    val demand: Int = 0,
    val unsoldClips: BigInteger = BigInteger("5"),
    val clipMakerLevel: Int = 0,
    val clipperCost: Double = 5.0,
    val wires: BigInteger = BigInteger("1000"),
    val wireCost: Double = 15.0,
    val wireBasePrice: Double = 15.0,
    val wirePriceTimer: Int = 0,
    val wireSupply: Int = 1000,
    val demandBoost: Int = 1,
    val marketingEffectiveness: Int = 1,
    val prestigeU: Int = 0,
    val income: Double = 0.0,
    val clipsSold: BigInteger = BigInteger("0"),
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
                uiState.sellClips()
                // Attendre 100 millisecondes
                delay(100)
            }
        }

        // Coroutine pour la production de trombones
        viewModelScope.launch {
            while (isActive) {
                uiState.autoClipperProduction() // Appelle la fonction de production
                delay(1000) // Produit toutes les 1000ms
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
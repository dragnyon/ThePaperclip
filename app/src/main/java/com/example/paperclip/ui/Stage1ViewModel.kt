package com.example.paperclip.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.paperclip.data.Stage1
import com.example.paperclip.domain.Business.Companion.lowerPrice
import com.example.paperclip.domain.Business.Companion.makePaperClips
import com.example.paperclip.domain.Business.Companion.raisePrice
import com.example.paperclip.domain.Business.Companion.updateDemand
import com.example.paperclip.domain.Business.Companion.upgradeCostMarket
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.math.BigDecimal

class Stage1ViewModel : ViewModel() {

    val uiState: MutableState<UiState> = mutableStateOf(UiState())

    init {
        onUiEvent(OnEvent.OnInit)
        test()
    }

    fun onUiEvent(uiEvent: OnEvent) {
        when (uiEvent) {
            is OnEvent.OnInit -> {
                uiState.value = UiState(
                    nbPaperclips = Stage1.nbPaperclips,
                    price = Stage1.price,
                    funds = Stage1.funds,
                    costMarket = Stage1.costMarket,
                    levelMarket = Stage1.levelMarket,
                    demand = Stage1.demand
                )
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
    }
}
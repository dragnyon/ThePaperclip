package com.example.paperclip.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.paperclip.data.Stage1
import com.example.paperclip.domain.Business.Companion.upgradeCostMarket
import java.math.BigDecimal

class Stage1ViewModel : ViewModel() {

    val uiState: MutableState<UiState> = mutableStateOf(UiState())

    init {
        onUiEvent(OnEvent.OnInit)
    }

    fun onUiEvent(uiEvent: OnEvent) {
        when (uiEvent) {
            is OnEvent.OnInit -> {
                uiState.value = UiState(
                    nbPaperclips = Stage1.nbPaperclips,
                    price = Stage1.price,
                    funds = Stage1.funds,
                    costMarket = Stage1.costMarket,
                    levelMarket = Stage1.levelMarket

                )
            }

            is OnEvent.OnGenerateClick -> {
                uiState.value = uiState.value.copy(
                    nbPaperclips = uiState.value.nbPaperclips.inc(),

                    )
            }


            is OnEvent.RaisePrice -> {
                uiState.value = uiState.value.copy(
                    price = uiState.value.price.add(BigDecimal("0.01"))

                )
            }


            is OnEvent.LowerPrice -> {
                uiState.value = uiState.value.copy(
                    price = uiState.value.price.subtract(BigDecimal("0.01"))

                )
            }

            is OnEvent.UpgradeMarket -> {
                uiState.upgradeCostMarket()

            }


        }
    }
}
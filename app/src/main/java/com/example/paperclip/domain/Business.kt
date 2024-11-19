package com.example.paperclip.domain

import androidx.compose.runtime.MutableState
import com.example.paperclip.ui.UiState

class Business {

    companion object {

        fun MutableState<UiState>.upgradeCostMarket() {

            val finalFunds = this.value.funds - this.value.costMarket
            val finalCost = this.value.costMarket * 2
            val finalLevel = this.value.levelMarket + 1
            if (finalFunds >= 0) {
                this.value = this.value.copy(
                    funds = finalFunds,
                    costMarket = finalCost,
                    levelMarket = finalLevel
                )
            }


        }


    }


}
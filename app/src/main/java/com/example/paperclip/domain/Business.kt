package com.example.paperclip.domain

import androidx.compose.runtime.MutableState
import com.example.paperclip.domain.Business.Companion.lowerPrice
import com.example.paperclip.ui.UiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.math.BigDecimal
import kotlin.math.ceil

class Business {

    companion object {

        fun MutableState<UiState>.makePaperClips(){
            this.value = this.value.copy(
                nbPaperclips = this.value.nbPaperclips.inc(),

                )
        }
        
        
        
        fun MutableState<UiState>.upgradeCostMarket() {

            val finalFunds = this.value.funds - this.value.costMarket.toBigDecimal()
            val finalCost = this.value.costMarket * 2
            val finalLevel = this.value.levelMarket + 1

                this.value = this.value.copy(
                    funds = finalFunds,
                    costMarket = finalCost,
                    levelMarket = finalLevel
                )

        }

        fun MutableState<UiState>.raisePrice() {
            this.value = this.value.copy(
                price = this.value.price.plus("0.01".toBigDecimal()),
            )
        }

        fun MutableState<UiState>.lowerPrice() {
            val res = this.value.price.compareTo("0.01".toBigDecimal())

            if (res == 1) {
                this.value = this.value.copy(
                    price = this.value.price.minus("0.01".toBigDecimal())
                )
            }
        }

        fun MutableState<UiState>.updateDemand() {
            val demand = this.value.demand
            val price = this.value.price
            val levelMarket = this.value.levelMarket
            
            val demandValue = ceil((levelMarket * 10) / (price.toDouble() + 1)).toInt()

            this.value = this.value.copy(
                demand = demandValue
            )
        }

        fun MutableState<UiState>.sellClips() {

            var unsoldClips = this.value.unsoldClips
            val demand = this.value.demand
            val margin = this.value.price
            var funds = this.value.funds

            if (unsoldClips.compareTo("0".toBigInteger()) == 1) {
                val sellQty = unsoldClips.min(demand.toBigInteger())
                unsoldClips = unsoldClips.minus(sellQty)
                funds = funds.plus(sellQty.toBigDecimal().multiply(margin))

                this.value = this.value.copy(
                    unsoldClips = unsoldClips,
                    funds = funds
                )
            }
        }

        //fun MutableState<UiState>.autoClipperProduction() {
        //  val wires = this.value.wires
        //  val clipmakerLevel = this.value.clipmakerLevel
        //  var clips = this.value.clips
        //  var unsoldClips = this.value.unsoldClips
//
        //          if (wire >= clipmakerLevel) {
        //      clips = clips + clipmakerLevel
        //      unsoldClips = unsoldClips + clipmakerLevel
        //      this.value = this.value.copy(
        //          clips = clips,
        //          unsoldClips = unsoldClips,
        //          wire = wire - clipmakerLevel
        //      )
        //  }
        //}





    }
}
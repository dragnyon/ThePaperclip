package com.example.paperclip.domain

import androidx.compose.runtime.MutableState
import com.example.paperclip.domain.Business.Companion.raisePrice
import com.example.paperclip.ui.views.stage1.UiState

import java.math.BigInteger

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.pow

class Business {

    companion object {

        fun MutableState<UiState>.makePaperClips() {
            var wires = this.value.wires
            var clips = this.value.nbPaperclips
            var unsoldClips = this.value.unsoldClips

            val res = wires.compareTo("1".toBigInteger())

            if (res == 1 || res == 0) {
                clips = clips.inc()
                unsoldClips = unsoldClips.inc()
                wires = wires.dec()

                this.value = this.value.copy(
                    nbPaperclips = clips,
                    unsoldClips = unsoldClips,
                    wires = wires
                )
            }
        }


        fun MutableState<UiState>.upgradeCostMarket() {

            val finalFunds = this.value.funds - this.value.costMarket
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
                price = Math.round((this.value.price + 0.01) * 100) / 100.0
            )
        }

        fun MutableState<UiState>.lowerPrice() {

            if (this.value.price > 0.01) {
                this.value = this.value.copy(
                    price = Math.round((this.value.price - 0.01) * 100) / 100.0
                )
            }
        }

        fun MutableState<UiState>.updateDemand() {
            var demand: Int
            val price = this.value.price
            val levelMarket = this.value.levelMarket
            val marketingEffectiveness = this.value.marketingEffectiveness
            val demandBoost = this.value.demandBoost
            val curveMarket = 1.1.pow((levelMarket - 1).toDouble())
            val prestigeU = this.value.prestigeU

            demand = Math.round(((((0.80 / price) * curveMarket * marketingEffectiveness) * demandBoost) * 10)).toInt()
            demand += ((demand / 10) * prestigeU)
            this.value = this.value.copy(
                demand = demand
            )
        }

        fun MutableState<UiState>.sellClips() {

            var unsoldClips = this.value.unsoldClips
            val demand = this.value.demand
            val margin = this.value.price
            var funds = this.value.funds
            var income = this.value.income
            val transaction: Int
            val clipsSold = this.value.clipsSold
            val number: Double = floor(0.7 * demand.toDouble().pow(1.15))
            if (Math.random() < (demand.toDouble()/100))
            {
                if (unsoldClips.compareTo("0".toBigInteger()) == 1) {
                    if( number > unsoldClips.toDouble()) {
                        transaction = (unsoldClips.toDouble() * margin * 1000.0).toInt() / 1000
                        income += transaction
                        funds = kotlin.math.floor((funds + transaction) * 100) / 100
                        clipsSold.add((number.toInt()).toBigInteger())
                        unsoldClips = BigInteger("0")
                    }
                    else {
                        transaction = (number * margin * 1000.0).toInt() / 1000
                        income += transaction
                        funds = kotlin.math.floor((funds + transaction) * 100) / 100
                        clipsSold.add((number.toInt()).toBigInteger())
                        unsoldClips.minus(number.toInt().toBigInteger());
                    }

                    this.value = this.value.copy(
                        unsoldClips = unsoldClips,
                        funds = funds,
                        income = income
                    )
                }
            }
        }
    }
}
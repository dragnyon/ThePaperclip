package com.example.paperclip.domain

import androidx.compose.runtime.MutableState
import com.example.paperclip.ui.views.stage1.UiState
import kotlin.math.pow

class Manufacturing {
    companion object {
        fun MutableState<UiState>.buyWire() {
            var wires = this.value.wires
            var wireCost = this.value.wireCost
            var funds = this.value.funds
            val res = funds.compareTo(10.toBigDecimal())

            if (res == 1 || res == 0) {
                wires = wires.plus(this.value.wireSupply.toBigInteger())
                funds = funds.minus(wireCost.toBigDecimal())

                this.value = this.value.copy(
                    wires = wires,
                    funds = funds
                )
            }
        }


        fun MutableState<UiState>.makeClipper() {
            var funds = this.value.funds
            var clipMakerLevel = this.value.clipMakerLevel
            var clipperCost = this.value.clipperCost

            val res = funds.compareTo(clipperCost.toBigDecimal())

            if (res == 1 || res == 0) {
                funds = funds.minus(clipperCost.toBigDecimal())
                clipMakerLevel = clipMakerLevel.inc()
                clipperCost = 1.1.pow(clipMakerLevel.toDouble()) + 5

                this.value = this.value.copy(
                    funds = funds,
                    clipMakerLevel = clipMakerLevel,
                    clipperCost = clipperCost
                )
            }
        }

        fun MutableState<UiState>.autoClipperProduction() {
            val clipMakerLevel = this.value.clipMakerLevel
            var wires = this.value.wires
            var clips = this.value.nbPaperclips
            var unsoldClips = this.value.unsoldClips

            val res = wires.compareTo(clipMakerLevel.toBigInteger())
            if (res == 1 || res == 0) {
                clips = clips.plus(clipMakerLevel.toBigInteger())
                unsoldClips = unsoldClips.plus(clipMakerLevel.toBigInteger())
                wires = wires.minus(clipMakerLevel.toBigInteger())

                this.value = this.value.copy(
                    nbPaperclips = clips,
                    unsoldClips = unsoldClips,
                    wires = wires
                )
            }
        }
    }
}
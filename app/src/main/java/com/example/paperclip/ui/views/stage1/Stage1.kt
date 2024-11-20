package com.example.paperclip.ui.views.stage1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.paperclip.ui.composables.business.Business
import com.example.paperclip.ui.composables.manufacturing.Manufacturing
import com.example.paperclip.ui.composables.messagesBox.MessageBox
import com.example.paperclip.ui.composables.paperclips.Paperclips


@Composable
fun Stage1(
    viewModel: Stage1ViewModel = viewModel()


) {

    val uiState = viewModel.uiState

    Column(Modifier.verticalScroll(rememberScrollState())) {
        MessageBox()
        Paperclips(
            uiState.value.nbPaperclips,
            onClickMakePaperclips = { viewModel.onUiEvent(OnEvent.OnGenerateClick) }
        )
        Business(
            price = uiState.value.price,
            funds = uiState.value.funds,
            costMarket = uiState.value.costMarket,
            levelMarket = uiState.value.levelMarket,
            onClickRaise = { viewModel.onUiEvent(OnEvent.RaisePrice) },
            onClickLower = { viewModel.onUiEvent(OnEvent.LowerPrice) },
            onClickMarket = { viewModel.onUiEvent(OnEvent.UpgradeMarket) },
            demand = uiState.value.demand,
            unsold = uiState.value.unsoldClips
        )
        Manufacturing(
            funds = uiState.value.funds,
            onClickAutoClippers = { viewModel.onUiEvent(OnEvent.MakeClipper) },
            costAutoClippers = uiState.value.clipperCost,
            nbAutoClippers = uiState.value.clipMakerLevel,
            wires = uiState.value.wires,
            costWire = uiState.value.wireCost.toInt(),
            onClickWire = { viewModel.onUiEvent(OnEvent.BuyWire) },
        )
    }
}



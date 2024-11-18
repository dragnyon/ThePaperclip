package com.example.paperclip.ui

sealed class OnEvent {
    object OnInit : OnEvent()
    object OnGenerateClick : OnEvent()

    //Business
    object RaisePrice : OnEvent()
    object LowerPrice : OnEvent()
    object UpgradeMarket : OnEvent()
}
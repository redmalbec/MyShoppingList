package com.example.myshoppinglist.domain

import android.util.Log

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun deleteShopItem(shopItem: ShopItem) {
//        Log.d("DeleteShopItemUseCase", "deleteShopItem-1")
        shopListRepository.deleteShopItem(shopItem)
//        Log.d("DeleteShopItemUseCase", "deleteShopItem-2")
    }
}
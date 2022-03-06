package com.example.myshoppinglist.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myshoppinglist.domain.ShopItem
import com.example.myshoppinglist.domain.ShopListRepository

object ShopListRepositoryImpl  : ShopListRepository {

    private val shopListLD = MutableLiveData<List<ShopItem>>()
//    private val shopList = mutableListOf<ShopItem>()
    private val shopList = sortedSetOf<ShopItem>({ o1, o2 -> o1.id.compareTo(o2.id) })

    private var autoIncrementId = 0

    init {
        for (i in 0 until 1000) {
            val item = ShopItem("Name $i", i, true)
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
//        Log.d("ShopListRepositoryImpl", "deleteShopItem-1")
        shopList.remove(shopItem)
//        Log.d("ShopListRepositoryImpl", "deleteShopItem-2")
        updateList()
//        Log.d("ShopListRepositoryImpl", "deleteShopItem-3")
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
//        Log.d("ShopListRepositoryImpl", "editShopItem-1")
        shopList.remove(oldElement)
//        Log.d("ShopListRepositoryImpl", "editShopItem-2")
        addShopItem(shopItem)
//        Log.d("ShopListRepositoryImpl", "editShopItem-3")
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Element with id $shopItemId not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    private fun updateList() {
        shopListLD.value = shopList.toList()
    }
}
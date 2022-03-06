package com.example.myshoppinglist.presentation

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import com.example.myshoppinglist.domain.ShopItem

class ShopItemDiffCallback: DiffUtil.ItemCallback<ShopItem>() {

    override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
//        Log.d("ShopItemDiffCallback", "areItemsTheSame")
        return oldItem.id == newItem.id

    }

    override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
//        Log.d("ShopItemDiffCallback", "areContentsItemsTheSame")
        return oldItem == newItem
    }
}

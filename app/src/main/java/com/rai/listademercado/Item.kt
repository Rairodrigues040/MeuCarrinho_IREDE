package com.rai.listademercado

data class Item(
    val name: String,
    val category: Category,
    val quantityText: String,
    val checked: Boolean = false
)
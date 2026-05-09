package com.rai.listademercado

class Item (
    val name: String,
    val category: Category,
    val isChecked: Boolean = false,
    val quantityText: String
) {
}
package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int, val updater: (Item) -> Unit = Item::update) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}

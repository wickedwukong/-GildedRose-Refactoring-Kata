package com.gildedrose

class GildedRose(var items: Array<Item>) {
    fun updateQuality() {
        for (item in items) {
            item.update()
        }
    }

}

val x: (Item) -> Unit = Item::update
fun Item.update() {
    fun decrementQuality(item:Item, byAmount:Int = 1){
        item.quality = item.quality - byAmount
    }

    fun incrementQuality(item:Item){
        item.quality = item.quality + 1
    }

    if (this.name != "Aged Brie" && this.name != "Backstage passes to a TAFKAL80ETC concert") {
        if (this.quality > 0) {
            when {
                this.name != "Sulfuras, Hand of Ragnaros" -> {
                    decrementQuality(this)
                }
            }
        }
    } else {
        if (this.quality < 50) {
            incrementQuality(this)

            if (this.name == "Backstage passes to a TAFKAL80ETC concert") {
                if (this.sellIn < 11) {
                    if (this.quality < 50) {
                        incrementQuality(this)
                    }
                }

                if (this.sellIn < 6) {
                    if (this.quality < 50) {
                        incrementQuality(this)
                    }
                }
            }
        }
    }

    if (this.name != "Sulfuras, Hand of Ragnaros") {
        this.sellIn = this.sellIn - 1
    }

    if (this.sellIn < 0) {
        if (this.name != "Aged Brie") {
            if (this.name != "Backstage passes to a TAFKAL80ETC concert") {
                if (this.quality > 0) {
                    if (this.name != "Sulfuras, Hand of Ragnaros") {
                        decrementQuality(this)
                    }
                }
            } else {
                decrementQuality(this, this.quality)
            }
        } else {
            if (this.quality < 50) {
                incrementQuality(this)
            }
        }
    }

}

fun Brie(sellIn: Int, quality: Int) : Item = Item("Aged Brie", sellIn, quality, updater = Item::update)
fun Sulfuras(sellIn: Int, quality: Int) : Item = Item("Sulfuras", sellIn, quality, updater = Item::update)
fun Pass(sellIn: Int, quality: Int) : Item = Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality, updater = Item::update)


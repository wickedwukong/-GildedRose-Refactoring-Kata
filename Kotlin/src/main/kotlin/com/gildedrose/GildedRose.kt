package com.gildedrose

class GildedRose(var items: Array<Item>) {

    private fun decrementQuality(item:Item, byAmount:Int = 1){
        item.quality = item.quality - byAmount
    }

    private fun incrementQuality(item:Item){
        item.quality = item.quality + 1
    }

    fun updateQuality() {
        for (item in items) {
            if (item.name != "Aged Brie" && item.name != "Backstage passes to a TAFKAL80ETC concert") {
                if (item.quality > 0) {
                    when {
                        item.name != "Sulfuras, Hand of Ragnaros" -> {
                            decrementQuality(item)
                        }
                    }
                }
            } else {
                if (item.quality < 50) {
                    incrementQuality(item)

                    if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                incrementQuality(item)
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                incrementQuality(item)
                            }
                        }
                    }
                }
            }

            if (item.name != "Sulfuras, Hand of Ragnaros") {
                item.sellIn = item.sellIn - 1
            }

            if (item.sellIn < 0) {
                if (item.name != "Aged Brie") {
                    if (item.name != "Backstage passes to a TAFKAL80ETC concert") {
                        if (item.quality > 0) {
                            if (item.name != "Sulfuras, Hand of Ragnaros") {
                                decrementQuality(item)
                            }
                        }
                    } else {
                        decrementQuality(item, item.quality)
                    }
                } else {
                    if (item.quality < 50) {
                        incrementQuality(item)
                    }
                }
            }
        }
    }

}


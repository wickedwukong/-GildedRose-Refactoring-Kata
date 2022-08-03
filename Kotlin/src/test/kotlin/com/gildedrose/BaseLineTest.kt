package com.gildedrose

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class BaseLineTest {
    @Test
    fun baseLine() {

        val byteArrayOutputStream = ByteArrayOutputStream()
        val output = PrintStream(byteArrayOutputStream)

        val items = arrayOf(
            Item("+5 Dexterity Vest", 10, 20), //
            Brie(2, 0), //
            Item("Elixir of the Mongoose", 5, 7), //
            Sulfuras(0, 80), //
            Sulfuras(-1, 80),
            Pass(15, 20),
            Pass(10, 49),
            Pass(5, 49),
            // this conjured item does not work properly yet
            Item("Conjured Mana Cake", 3, 6)
        )

        val app = GildedRose(items)

        var days = 2

        for (i in 0..days - 1) {
            output.println("-------- day $i --------")
            output.println("name, sellIn, quality")
            for (item in items) {
                output.println(item)
            }
            output.println()
            app.updateQuality()
        }


        val theExpected = """-------- day 0 --------
name, sellIn, quality
+5 Dexterity Vest, 10, 20
Aged Brie, 2, 0
Elixir of the Mongoose, 5, 7
Sulfuras, Hand of Ragnaros, 0, 80
Sulfuras, Hand of Ragnaros, -1, 80
Backstage passes to a TAFKAL80ETC concert, 15, 20
Backstage passes to a TAFKAL80ETC concert, 10, 49
Backstage passes to a TAFKAL80ETC concert, 5, 49
Conjured Mana Cake, 3, 6

-------- day 1 --------
name, sellIn, quality
+5 Dexterity Vest, 9, 19
Aged Brie, 1, 1
Elixir of the Mongoose, 4, 6
Sulfuras, Hand of Ragnaros, 0, 80
Sulfuras, Hand of Ragnaros, -1, 80
Backstage passes to a TAFKAL80ETC concert, 14, 21
Backstage passes to a TAFKAL80ETC concert, 9, 50
Backstage passes to a TAFKAL80ETC concert, 4, 50
Conjured Mana Cake, 2, 5

"""

        Assertions.assertEquals(theExpected, byteArrayOutputStream.toString())


    }

}

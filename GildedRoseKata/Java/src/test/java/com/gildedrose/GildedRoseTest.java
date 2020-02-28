package com.gildedrose;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

  @Test
  void something() {
    String result = updateGildedRose("steelSword", 20, 5);

    //assertEquals(rose.items.length, items.length);
    Approvals.verify(result);
  }

  @Test
  void something_more() {
    String[] names = new String[]{
        "Aged Brie",
        "Backstage passes to a TAFKAL80ETC concert",
        "Sulfuras, Hand of Ragnaros",
        "applesauce"};
    Integer[] sellins = new Integer[]{4, 5, 10, 40, 0, -1};
    Integer[] qualities = new Integer[]{-1, 0, 10, 50, 51};

    CombinationApprovals.verifyAllCombinations(
        (name, sellin, quality) -> updateGildedRose(name, sellin, quality),
        names, sellins, qualities
    );
  }

  private String updateGildedRose(String name, int sellin, int quality) {
    Item[] x = new Item[] {new Item(name, sellin, quality)};

    GildedRose rose = new GildedRose(x);
    rose.updateQuality();

    return rose.items[0].toString();
  }
}
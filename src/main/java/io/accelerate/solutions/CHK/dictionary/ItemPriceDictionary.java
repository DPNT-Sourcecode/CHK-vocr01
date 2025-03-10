package io.accelerate.solutions.CHK.dictionary;

import java.util.TreeMap;

public class itemPriceDictionary {
    public static TreeMap<Character, Integer> itemPriceDictionary = new TreeMap<>();

    static {
        itemPriceDictionary.put('A', 50);
        itemPriceDictionary.put('B', 30);
        itemPriceDictionary.put('C', 20);
        itemPriceDictionary.put('D', 15);
        itemPriceDictionary.put('E', 40);
    }
}

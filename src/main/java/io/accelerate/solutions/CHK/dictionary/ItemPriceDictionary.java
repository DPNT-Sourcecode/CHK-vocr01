package io.accelerate.solutions.CHK.dictionary;

import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * The type Item price dictionary.
 */
public class ItemPriceDictionary {
    /**
     * The constant itemPriceDictionary.
     */
    public static TreeMap<Character, Integer> itemPriceDictionary = new TreeMap<>();

    static {
        itemPriceDictionary.put('A', 50);
        itemPriceDictionary.put('B', 30);
        itemPriceDictionary.put('C', 20);
        itemPriceDictionary.put('D', 15);
        itemPriceDictionary.put('E', 40);
    }

    private static final String VALID_ITEMS_REGEX = "[" +
            itemPriceDictionary.keySet().
                    stream().
                    map(String::valueOf).
                    collect(Collectors.joining()) + "]*";

    public static final Pattern VALID_ITEMS_PATTERN = Pattern.compile(VALID_ITEMS_REGEX);

}

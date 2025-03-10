package io.accelerate.solutions.CHK.dictionary;

import io.accelerate.solutions.CHK.FreeItemPromo;
import io.accelerate.solutions.CHK.MultiPricePromo;
import io.accelerate.solutions.CHK.Promotion;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ItemPromoDictionary {
    public static TreeMap<Character, List<Promotion>> itemPromoDictionary = new TreeMap<>();

    static {
        itemPromoDictionary.put('A', List.of(
                new MultiPricePromo('A', 3, 130),
                new MultiPricePromo('A', 5, 200)
        ));
        itemPromoDictionary.put('B', List.of(new MultiPricePromo('B', 2, 45)));
        itemPromoDictionary.put('E', List.of(new FreeItemPromo('E', 2, Map.of('B', 1))));
    }
}

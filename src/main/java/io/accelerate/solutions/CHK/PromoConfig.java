package io.accelerate.solutions.CHK;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PromoConfig {

    private static final Map<Character, Integer> PRICES = Map.of(
            'A', 50,
            'B', 30,
            'C', 20,
            'D', 15,
            'E', 40
    );

    private static final String VALID_ITEMS_REGEX = "[" +
            PRICES.keySet().
                    stream().
                    map(String::valueOf).
                    collect(Collectors.joining()) + "]*";

    public static final Pattern VALID_ITEMS_PATTERN = Pattern.compile(VALID_ITEMS_REGEX);

    public static Integer getUnitPrice(Character item) {
        return PRICES.get(item);
    }

    public static List<MultiPricePromo> getMultiPricePromotionForItem(Character item) {
        List<MultiPricePromo> promotions = new ArrayList<MultiPricePromo>();

        switch (item) {
            case 'A':
                promotions.add(new MultiPricePromo('A', 3, 130));
                promotions.add(new MultiPricePromo('A', 5, 200));
                break;
            case 'B':
                break;
            default:
                break;
        }

        return promotions;
    }

    public static List<FreeItemPromo> getFreeItemPromotionForItem(Character item) {
        List<FreeItemPromo> promotions = new ArrayList<FreeItemPromo>();

        promotions.add(new FreeItemPromo('E', 2, Map.of('B', 1)));

        return promotions;
    }
}


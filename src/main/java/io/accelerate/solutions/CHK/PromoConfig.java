package io.accelerate.solutions.CHK;

import io.accelerate.solutions.CHK.promoTypes.FreeItemPromo;
import io.accelerate.solutions.CHK.promoTypes.MultiPricePromo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * The type Promo config.
 */
public class PromoConfig {

    private static final Map<Character, Integer> PRICES = Map.ofEntries(
            Map.entry('A', 50),
            Map.entry('B', 30),
            Map.entry('C', 20),
            Map.entry('D', 15),
            Map.entry('E', 40),
            Map.entry('F', 10),
            Map.entry('G', 20),
            Map.entry('H', 10),
            Map.entry('I', 35),
            Map.entry('J', 60),
            Map.entry('K', 80),
            Map.entry('L', 90),
            Map.entry('M', 15),
            Map.entry('N', 40),
            Map.entry('O', 10),
            Map.entry('P', 50),
            Map.entry('Q', 30),
            Map.entry('R', 50),
            Map.entry('S', 30),
            Map.entry('T', 20),
            Map.entry('U', 40),
            Map.entry('V', 50),
            Map.entry('W', 20),
            Map.entry('X', 90),
            Map.entry('Y', 10),
            Map.entry('Z', 50)
    );

    private static final String VALID_ITEMS_REGEX = "[" +
            PRICES.keySet().
                    stream().
                    map(String::valueOf).
                    collect(Collectors.joining()) + "]*";

    /**
     * The constant VALID_ITEMS_PATTERN.
     */
    public static final Pattern VALID_ITEMS_PATTERN = Pattern.compile(VALID_ITEMS_REGEX);

    /**
     * Gets unit price.
     *
     * @param item the item
     * @return the unit price
     */
    public static Integer getUnitPrice(Character item) {
        return PRICES.get(item);
    }

    /**
     * Gets multi price promotion for item.
     *
     * @param item the item
     * @return the multi price promotion for item
     */
    public static List<MultiPricePromo> getMultiPricePromotionForItem(Character item) {
        List<MultiPricePromo> promotions = new ArrayList<>();

        switch (item) {
            case 'A':
                promotions.add(new MultiPricePromo('A', 3, 130));
                promotions.add(new MultiPricePromo('A', 5, 200));
                break;
            case 'B':
                promotions.add(new MultiPricePromo('B', 2, 45));
                break;
            default:
                break;
        }

        return promotions;
    }

    /**
     * Gets free item promotion for item.
     *
     * @return the free item promotion for item
     */
    public static List<FreeItemPromo> getFreeItemPromotionForItem() {
        List<FreeItemPromo> promotions = new ArrayList<>();

        promotions.add(new FreeItemPromo('E', 2, Map.of('B', 1)));
        promotions.add(new FreeItemPromo('F', 2, Map.of('F', 1)));

        return promotions;
    }
}




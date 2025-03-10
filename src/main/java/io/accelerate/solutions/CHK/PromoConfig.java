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

        return promotions;
    }
}

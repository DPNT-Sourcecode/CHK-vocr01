package io.accelerate.solutions.CHK;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PromoConfig {

    private static final Map<Character, Integer> PRICES = Map.of(
            'A', 50,
            'B', 30,
            'C', 20,
            'D', 15,
            'E', 40
    );

    public static Integer getUnitPrice(Character item) {
        return PRICES.get(item);
    }

    public static List<MultiPricePromo> getPromotionForItem(Character item) {
        List<MultiPricePromo> promotions = new ArrayList<MultiPricePromo>();

        switch (item) {
            case 'A':
                promotions.add(new MultiPricePromo('A', 3, 130));
                promotions.add(new MultiPricePromo('A', 5, 200));
                break;
            case 'B':
                promotions.add(new MultiPricePromo('B', 2, 45));
        }
    }
}

package io.accelerate.solutions.CHK;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * The type Checkout solution.
 */
public class CheckoutSolution {

    static final Map<Character, Integer> PRICES = Map.of(
            'A', 50,
            'B', 30,
            'C', 20,
            'D', 15,
            'E', 40
    );

    private static final Map<Character, int[]> PROMOTIONS = Map.of(
            'A', new int[]{3, 130},
            'B', new int[]{2, 45},
            'E', new int[]{2, -1 * PRICES.get('B')}
    );

    private static final String VALID_ITEMS_REGEX = "[" +
            PRICES.keySet().
                    stream().
                    map(String::valueOf).
                    collect(Collectors.joining()) + "]*";

    private static final Pattern VALID_ITEMS_PATTERN = Pattern.compile(VALID_ITEMS_REGEX);

    /**
     * Supermarket checkout that calculates the total price of a number of items.
     *
     * @param skus the skus, the items in the form of the example: 'AABCDD'.
     * @return the total price.
     */
    public Integer checkout(String skus) {
        Integer validationResult = validateSkus(skus);
        if (validationResult != null) {
            return validationResult;
        }

        Map<Character, Integer> items = new HashMap<>();

        for (char c : skus.toCharArray()) {
            items.put(c, items.getOrDefault(c, 0) + 1);
        }

        int totalPrice = 0;

        for (Map.Entry<Character, int[]> promo : PROMOTIONS.entrySet()) {
            char promoItem = promo.getKey();

            if (items.containsKey(promoItem)) {
                int quantity = items.get(promoItem);
                int promoQty = promo.getValue()[0];
                int promoPrice = promo.getValue()[1];

                totalPrice += (quantity / promoQty) * promoPrice;
                items.put(promoItem, quantity % promoQty);
            }
        }

        for (Map.Entry<Character, Integer> entry : items.entrySet()) {
            totalPrice += entry.getValue() * PRICES.get(entry.getKey());
        }

        return totalPrice;
    }

    public static Integer validateSkus(String skus) {
        if (skus == null || !VALID_ITEMS_PATTERN.matcher(skus.trim()).matches()) {
            return -1;
        }

        if (skus.isBlank()) {
            return 0;
        }
        return null;
    }
}



package io.accelerate.solutions.CHK;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CheckoutSolution {

    private static final Map<Character, Integer> PRICES = Map.of(
            'A', 50,
            'B', 30,
            'C', 20,
            'D', 15
    );

    private static final Map<Character, int[]> PROMOTIONS = Map.of(
            'A', new int[]{3, 130},
            'B', new int[]{2, 45}
    );

    private static final String VALID_ITEMS_REGEX = "[" +
            PRICES.keySet().
                    stream().
                    map(String::valueOf).
                    collect(Collectors.joining()) + "]";

    private static final Pattern VALID_ITEMS_PATTERN = Pattern.compile(VALID_ITEMS_REGEX);

    public Integer checkout(String skus) {
        if (skus == null || skus.isBlank() || !VALID_ITEMS_PATTERN.matcher(skus.trim()).find()) {
            return -1;
        }

        Map<Character, Integer> items = new HashMap<>();

        for (char c : skus.toCharArray()) {
            items.put(c, items.getOrDefault(c, 0) + 1);
        }

        int totalPrice = 0;

        for(Map.Entry<Character, int[]> promo : PROMOTIONS.entrySet()) {
            char promoItem = promo.getKey();

            if(items.containsKey(promoItem)) {
                int quantity = items.get(promoItem);
                int promoQty = promo.getValue()[0];
                int promoPrice = promo.getValue()[1];

                totalPrice += (quantity / promoQty) * promoPrice;
                quantity %= promoQty;
                items.put(promoItem, quantity);
            }
        }

        for(Map.Entry<Character, Integer> entry : items.entrySet()) {
            totalPrice += entry.getValue() * PRICES.get(entry.getKey());
        }

        return totalPrice;
    }
}




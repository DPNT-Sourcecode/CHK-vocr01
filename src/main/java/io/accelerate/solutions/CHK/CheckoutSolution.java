package io.accelerate.solutions.CHK;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * The type Checkout solution.
 */
public class CheckoutSolution {

    private static final Map<Character, Integer> PRICES = Map.of(
            'A', 50,
            'B', 30,
            'C', 20,
            'D', 15,
            'E', 40
    );

    private static final Map<Character, Promotion[]> PROMOTIONS = Map.of(
            'A', new Promotion[]{
                    new Promotion(3, 130),
                    new Promotion(5, 200)
            },
            'B', new Promotion[]{new Promotion(2, 45)},
            'E', new Promotion[]{new Promotion('E', 2, 'B')}
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

        for (Map.Entry<Character, Integer> entry : items.entrySet()) {
            char item = entry.getKey();
            int count = entry.getValue();
            Promotion[] promotions = PROMOTIONS.get(item);

            if (promotions != null) {
                totalPrice += applyBestPromo(item, count, promotions, items);
            } else {
                totalPrice += count * PRICES.get(item);
            }
        }

        return totalPrice;
    }

    private int applyBestPromo(char item, int count, Promotion[] promotions, Map<Character, Integer> checkOutItems) {
        int minTotal = count * PRICES.get(item);

        for (Promotion promotion : promotions) {
            int total = 0;
            int remaining = count;

            while (remaining >= promotion.getQuantityNeeded()) {
                total += promotion.getPromoPrice();
                remaining -= promotion.getQuantityNeeded();
            }

            //Applies other promos
            if (remaining > 0) {
                total += applyBestPromo(item, remaining, promotions, checkOutItems);
            }

            //Picks the best price
            if (total < minTotal) {
                minTotal = total;
            }
        }

        return minTotal;
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

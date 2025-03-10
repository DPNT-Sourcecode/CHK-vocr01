package io.accelerate.solutions.CHK;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.accelerate.solutions.CHK.dictionary.ItemPriceDictionary.VALID_ITEMS_PATTERN;
import static io.accelerate.solutions.CHK.dictionary.ItemPriceDictionary.itemPriceDictionary;
import static io.accelerate.solutions.CHK.dictionary.ItemPromoDictionary.itemPromoDictionary;

/**
 * The type Checkout solution.
 */
public class CheckoutSolution {

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

        Map<Character, Integer> items = parseSku(skus);

        int totalPrice = 0;

        for (Map.Entry<Character, Integer> entry : items.entrySet()) {
            char item = entry.getKey();
            int count = entry.getValue();
            Promotion[] promotions = PROMOTIONS.get(item);

            if (promotions != null) {
                totalPrice += applyBestPromo(item, count, promotions, items);
            } else {
                totalPrice += count * itemPriceDictionary.get(item);
            }
        }

        return totalPrice;
    }

    private static Map<Character, Integer> parseSku(String skus) {
        Map<Character, Integer> items = new HashMap<>();
        for (char c : skus.toCharArray()) {
            List<Promotion> promotion = itemPromoDictionary.get(c);
            if (itemPromoDictionary.get())
            items.put(c, items.getOrDefault(c, 0) + 1);
        }
        return items;
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


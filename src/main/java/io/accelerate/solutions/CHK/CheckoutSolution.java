package io.accelerate.solutions.CHK;

import io.accelerate.solutions.CHK.promoTypes.FreeItemPromo;
import io.accelerate.solutions.CHK.promoTypes.GroupItemPromo;
import io.accelerate.solutions.CHK.promoTypes.MultiPricePromo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.accelerate.solutions.CHK.PromoConfig.VALID_ITEMS_PATTERN;

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

        FreeItemPromo.applyFreeItemPromo(items);

        int totalPrice = GroupItemPromo.applyGroupItemPromo(items);

        for (Map.Entry<Character, Integer> entry : items.entrySet()) {
            char item = entry.getKey();
            int quantity = entry.getValue();

            List<MultiPricePromo> multiPricePromos = PromoConfig.getMultiPricePromotionForItem(item);
            totalPrice += MultiPricePromo.applyBestPromo(quantity, PromoConfig.getUnitPrice(item), multiPricePromos);
        }

        return totalPrice;
    }

    private static Map<Character, Integer> parseSku(String skus) {
        Map<Character, Integer> items = new HashMap<>();
        for (char c : skus.toCharArray()) {
            items.put(c, items.getOrDefault(c, 0) + 1);
        }
        return items;
    }

    private static Integer validateSkus(String skus) {
        if (skus == null || !VALID_ITEMS_PATTERN.matcher(skus.trim()).matches()) {
            return -1;
        }

        if (skus.isBlank()) {
            return 0;
        }
        return null;
    }
}

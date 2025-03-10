package io.accelerate.solutions.CHK.promoTypes;

import io.accelerate.solutions.CHK.PromoConfig;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * The type Multi price promo.
 */
public class MultiPricePromo {
    private final Character item;
    private final int promoQuantity;
    private final int promoPrice;

    /**
     * Instantiates a new Multi price promo.
     *
     * @param item          the item
     * @param promoQuantity the promo quantity
     * @param promoPrice    the promo price
     */
    public MultiPricePromo(Character item, int promoQuantity, int promoPrice) {
        this.item = item;
        this.promoQuantity = promoQuantity;
        this.promoPrice = promoPrice;
    }

    /**
     * Apply.
     *
     * @param checkOutItems the check out items
     */
    public int apply(Map<Character, Integer> checkOutItems) {
        return promoPrice * (checkOutItems.get(item) / promoQuantity) + PromoConfig.getUnitPrice(item) * (checkOutItems.get(item) % promoQuantity);
    }

    /**
     * Apply best promo int.
     *
     * @param quantity         the quantity
     * @param unitPrice        the unit price
     * @param multiPricePromos the multi price promos
     * @param items            the items
     * @return the int
     */
    public static int applyBestPromo(int quantity, int unitPrice, List<MultiPricePromo> multiPricePromos, Map<Character, Integer> items) {
        int[] minCosts = new int[quantity + 1];
        Arrays.fill(minCosts, Integer.MAX_VALUE);
        minCosts[0] = 0;

        for (int i = 1; i <= quantity; i++) {
            minCosts[i] = minCosts[i - 1] + unitPrice;

            for (MultiPricePromo multiPricePromo : multiPricePromos) {
                int promoQuantity = multiPricePromo.getPromoQuantity();
                if (i >= promoQuantity) {
                    int promoCost = multiPricePromo.apply(items);
                    minCosts[i] = Math.min(minCosts[i], minCosts[i - promoQuantity] + promoCost);
                }
            }
        }

        return minCosts[quantity];
    }

    public int getPromoQuantity() {
        return promoQuantity;
    }
}


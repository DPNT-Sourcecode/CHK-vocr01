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

    private int apply(int quantity) {
        return (quantity / promoQuantity) * promoPrice + ((quantity % promoQuantity) * PromoConfig.getUnitPrice(item));
    }

    /**
     * Apply best promo int.
     *
     * @param quantity         the quantity
     * @param unitPrice        the unit price
     * @param multiPricePromos the multi price promos
     * @return the int
     */
    public static int applyBestPromo(int quantity, int unitPrice, List<MultiPricePromo> multiPricePromos) {
        int[] minCosts = new int[quantity + 1];
        Arrays.fill(minCosts, Integer.MAX_VALUE);
        minCosts[0] = 0;

        for (int i = 1; i <= quantity; i++) {
            minCosts[i] = minCosts[i - 1] + unitPrice;

            for (MultiPricePromo multiPricePromo : multiPricePromos) {
                int promoQuantity = multiPricePromo.getPromoQuantity();

                if (i >= promoQuantity) {
                    int promoCost = multiPricePromo.apply(promoQuantity);
                    minCosts[i] = Math.min(minCosts[i], minCosts[i - promoQuantity] + promoCost);
                }
            }
        }

        return minCosts[quantity];
    }

    /**
     * Gets promo quantity.
     *
     * @return the promo quantity
     */
    public int getPromoQuantity() {
        return promoQuantity;
    }
}

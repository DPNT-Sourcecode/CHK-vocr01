package io.accelerate.solutions.CHK;

import java.util.Map;

import static io.accelerate.solutions.CHK.CheckoutSolution.PRICES;

/**
 * The type MultiPrice promotion.
 */
public class MultiPricePromotion extends Promotion {
    private final char item;
    private final int quantityNeeded;
    private final int promoPrice;

    /**
     * Instantiates a new Quantity promotion.
     *
     * @param quantityNeeded the quantity needed
     * @param promoPrice     the promo price
     */
    public MultiPricePromotion(char item, int quantityNeeded, int promoPrice) {
        this.item = item;
        this.quantityNeeded = quantityNeeded;
        this.promoPrice = promoPrice;
    }


    /**
     * Apply the promo to the product based on the check-out items and the quantity of the item.
     *
     * @param checkOutItems the check-out items
     * @return the promo applied
     */
    @Override
    int apply(Map<Character, Integer> checkOutItems) {
        int count = checkOutItems.getOrDefault(item, 0);
        int totalPrice = (count / quantityNeeded) * promoPrice;

        return totalPrice + (count % quantityNeeded) * PRICES.get(item);
    }
}





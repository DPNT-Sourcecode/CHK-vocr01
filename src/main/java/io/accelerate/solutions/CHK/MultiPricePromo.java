package io.accelerate.solutions.CHK;

import java.util.Map;

public class MultiPricePromo implements Promotion {
    private final Character item;
    private final int promoQuantity;
    private final int promoPrice;

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
    @Override
    public int apply(Map<Character, Integer> checkOutItems) {
        return promoPrice * (checkOutItems.get(item) / promoQuantity) + PromoConfig.getUnitPrice(item) * (checkOutItems.get(item) % promoQuantity);
    }
}


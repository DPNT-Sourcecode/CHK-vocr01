package io.accelerate.solutions.CHK;

public class MultiPricePromo implements PromotionInterface {
    private final int promoQuantity;
    private final int promoPrice;

    public MultiPricePromo(int promoQuantity, int promoPrice) {
        this.promoQuantity = promoQuantity;
        this.promoPrice = promoPrice;
    }

    /**
     * Apply int.
     *
     * @param item      the item
     * @param quantity  the quantity
     * @param unitPrice the unit price
     * @return the int
     */
    @Override
    public int apply(Character item, int quantity, int unitPrice) {
        return promoPrice * (quantity / promoQuantity) + unitPrice * (quantity % promoQuantity);
    }
}

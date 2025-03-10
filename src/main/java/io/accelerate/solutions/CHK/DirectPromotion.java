package io.accelerate.solutions.CHK;

/**
 * The interface Promotion interface.
 */
public interface DirectPromotion {

    /**
     * Apply int.
     *
     * @param item      the item
     * @param quantity  the quantity
     * @param unitPrice the unit price
     * @return the int
     */
    int apply(Character item, int quantity, int unitPrice);
}

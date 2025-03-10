package io.accelerate.solutions.CHK;

/**
 * The type Promotion promotion.
 */
public class Promotion {
    private final int quantityNeeded;
    private final int promoPrice;
    private final Character freeItem;

    /**
     * Instantiates a new Quantity promotion.
     *
     * @param quantityNeeded the quantity needed
     * @param promoPrice     the promo price
     */
    public Promotion(int quantityNeeded, int promoPrice) {
        this.quantityNeeded = quantityNeeded;
        this.promoPrice = promoPrice;
    }

    /**
     * Instantiates a new FreeItem promotion.
     *
     * @param quantityNeeded the quantity needed
     * @param promoPrice     the promo price
     * @param freeItem       the free item
     */
    public Promotion(int quantityNeeded, int promoPrice, Character freeItem) {
        this.quantityNeeded = quantityNeeded;
        this.promoPrice = promoPrice;
        this.freeItem = freeItem;
    }

}

package io.accelerate.solutions.CHK;

/**
 * The type Promotion promotion.
 */
public class Promotion {
    private final int quantityNeeded;
    private final int promoPrice;
    private Character freeItem;

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

    /**
     * Gets free item.
     *
     * @return the free item
     */
    public Character getFreeItem() {
        return freeItem;
    }

    /**
     * Gets promo price.
     *
     * @return the promo price
     */
    public int getPromoPrice() {
        return promoPrice;
    }

    /**
     * Gets quantity needed.
     *
     * @return the quantity needed
     */
    public int getQuantityNeeded() {
        return quantityNeeded;
    }

}

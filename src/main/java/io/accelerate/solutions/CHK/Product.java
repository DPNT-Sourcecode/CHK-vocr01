package io.accelerate.solutions.CHK;

import io.accelerate.solutions.CHK.promoTypes.FreeItemPromo;
import io.accelerate.solutions.CHK.promoTypes.MultiPricePromo;

import java.util.List;

public class Product {
    private final char itemCode;
    private final int unitPrice;
    private final List<MultiPricePromo> multiPricePromos;
    private final List<FreeItemPromo> freeItemPromos;

    public Product(char itemCode, int unitPrice, List<MultiPricePromo> multiPricePromos, List<FreeItemPromo> freeItemPromos) {
        this.itemCode = itemCode;
        this.unitPrice = unitPrice;
        this.multiPricePromos = multiPricePromos;
        this.freeItemPromos = freeItemPromos;
    }
}

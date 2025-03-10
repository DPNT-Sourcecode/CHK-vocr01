package io.accelerate.solutions.CHK;

import io.accelerate.solutions.CHK.promoTypes.FreeItemPromo;
import io.accelerate.solutions.CHK.promoTypes.MultiPricePromo;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private final char itemCode;
    private final int unitPrice;
    private final List<MultiPricePromo> multiPricePromos;
    private final List<FreeItemPromo> freeItemPromos;

    public Product(char itemCode, int unitPrice) {
        this.itemCode = itemCode;
        this.unitPrice = unitPrice;
        this.multiPricePromos = new ArrayList<>();
        this.freeItemPromos = new ArrayList<>();
    }

    public void addMultiPricePromo(MultiPricePromo multiPricePromo){
        this.multiPricePromos.add(multiPricePromo);
    }

    public void addFreeItemPromo(FreeItemPromo freeItemPromo){
        this.freeItemPromos.add(freeItemPromo);
    }

    public char getItemCode() {
        return itemCode;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public List<MultiPricePromo> getMultiPricePromos() {
        return multiPricePromos;
    }

    public List<FreeItemPromo> getFreeItemPromos() {
        return freeItemPromos;
    }
}



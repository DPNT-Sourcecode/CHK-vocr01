package io.accelerate.solutions.CHK.promoTypes;

import io.accelerate.solutions.CHK.PromoConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupItemPromo {
    private final Set<Character> group;
    private final int requiredQuantity;
    private final int groupPrice;

    public GroupItemPromo(Set<Character> group, int requiredQuantity, int groupPrice) {
        this.group = group;
        this.requiredQuantity = requiredQuantity;
        this.groupPrice = groupPrice;
    }

    public int applyPromo(Map<Character, Integer> items) {
        int totalGroupItems = 0;
        for (Character groupItem : group) {
            totalGroupItems += items.getOrDefault(groupItem, 0);
        }

        int numberOfBundles = totalGroupItems / requiredQuantity;
        if (numberOfBundles <= 0) {
            return 0;
        }

        List<GroupItem> itemList = new ArrayList<>();
        for (Character groupItem : group) {
            int quantity = items.getOrDefault(groupItem, 0);
            if (quantity > 0) {
                itemList.add(new GroupItem(groupItem, PromoConfig.getUnitPrice(groupItem), quantity));
            }
        }

        itemList.sort((a, b) -> Integer.compare(b.getUnitPrice(), a.getUnitPrice()));

        int totalCostOfBundles = numberOfBundles * groupPrice;
        int itemsOutOfPromotion = numberOfBundles * requiredQuantity;
    }

    private static class GroupItem {
        private final Character groupItem;
        private final int unitPrice;
        private final int quantity;

        private GroupItem(Character groupItem, int unitPrice, int quantity) {
            this.groupItem = groupItem;
            this.unitPrice = unitPrice;
            this.quantity = quantity;
        }

        public int getUnitPrice() {
            return unitPrice;
        }
    }
}



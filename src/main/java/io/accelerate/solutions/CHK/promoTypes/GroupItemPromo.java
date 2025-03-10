package io.accelerate.solutions.CHK.promoTypes;

import io.accelerate.solutions.CHK.PromoConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The type Group item promo.
 */
public class GroupItemPromo {
    private final Set<Character> group;
    private final int requiredQuantity;
    private final int groupPrice;

    /**
     * Instantiates a new Group item promo.
     *
     * @param group            the group
     * @param requiredQuantity the required quantity
     * @param groupPrice       the group price
     */
    public GroupItemPromo(Set<Character> group, int requiredQuantity, int groupPrice) {
        this.group = group;
        this.requiredQuantity = requiredQuantity;
        this.groupPrice = groupPrice;
    }

    /**
     * Apply group item promo.
     *
     * @param items the check-out items
     * @return the price of the items affected by the promo
     */
    public static Integer applyGroupItemPromo(Map<Character, Integer> items) {
        int totalGroupsPrices = 0;
        for (GroupItemPromo groupItemPromo : PromoConfig.getGroupItemPromotion()) {
            totalGroupsPrices += groupItemPromo.applyPromo(items);
        }
        return totalGroupsPrices;
    }

    private int applyPromo(Map<Character, Integer> checkOutItems) {
        int totalGroupItems = getTotalGroupItems(checkOutItems);

        int numberOfBundles = totalGroupItems / requiredQuantity;
        if (numberOfBundles <= 0) {
            return 0;
        }

        List<GroupItem> itemList = getGroupItemsInfo(checkOutItems);

        int totalCostOfBundles = numberOfBundles * groupPrice;
        int itemsInThePromo = numberOfBundles * requiredQuantity;

        removeItemsConsideredInThePromo(itemList, itemsInThePromo, checkOutItems);

        return totalCostOfBundles;
    }

    private static void removeItemsConsideredInThePromo(List<GroupItem> itemList, int itemsInThePromo, Map<Character, Integer> checkOutItems) {
        for (GroupItem item : itemList) {
            while (item.getQuantity() > 0 && itemsInThePromo > 0) {
                item.setQuantity(item.getQuantity() - 1);
                itemsInThePromo--;
            }
        }

        for (GroupItem item : itemList) {
            checkOutItems.put(item.getGroupItem(), item.getQuantity());
        }
    }

    private List<GroupItem> getGroupItemsInfo(Map<Character, Integer> items) {
        List<GroupItem> itemList = new ArrayList<>();
        for (Character groupItem : group) {
            int quantity = items.getOrDefault(groupItem, 0);
            if (quantity > 0) {
                itemList.add(new GroupItem(groupItem, PromoConfig.getUnitPrice(groupItem), quantity));
            }
        }

        //Order to remove higher prices first
        itemList.sort((a, b) -> Integer.compare(b.getUnitPrice(), a.getUnitPrice()));
        return itemList;
    }

    private int getTotalGroupItems(Map<Character, Integer> items) {
        int totalGroupItems = 0;
        for (Character groupItem : group) {
            totalGroupItems += items.getOrDefault(groupItem, 0);
        }
        return totalGroupItems;
    }

    private static class GroupItem {
        private final Character groupItem;
        private final int unitPrice;
        private int quantity;

        private GroupItem(Character groupItem, int unitPrice, int quantity) {
            this.groupItem = groupItem;
            this.unitPrice = unitPrice;
            this.quantity = quantity;
        }

        /**
         * Gets unit price.
         *
         * @return the unit price
         */
        public int getUnitPrice() {
            return unitPrice;
        }

        /**
         * Gets group item.
         *
         * @return the group item
         */
        public Character getGroupItem() {
            return groupItem;
        }

        /**
         * Gets quantity.
         *
         * @return the quantity
         */
        public int getQuantity() {
            return quantity;
        }

        /**
         * Sets quantity.
         *
         * @param quantity the quantity
         */
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}

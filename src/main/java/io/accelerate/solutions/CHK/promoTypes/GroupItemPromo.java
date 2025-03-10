package io.accelerate.solutions.CHK.promoTypes;

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

    }
}


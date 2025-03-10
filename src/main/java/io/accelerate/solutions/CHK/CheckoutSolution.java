package io.accelerate.solutions.CHK;

import java.util.Map;

public class CheckoutSolution {

    private static final Map<Character, Integer> PRICES = Map.of(
            'A', 50,
            'B', 30,
            'C', 20,
            'D', 15
    );

    private static final Map<Character, int[]> PROMOTIONS = Map.of(
            'A', new int[]{3,130},
            'B', new int[]{2,45}
    );

    public Integer checkout(String skus) {
        if (skus == null || skus.isBlank()) {
            return -1;
        }
    }
}


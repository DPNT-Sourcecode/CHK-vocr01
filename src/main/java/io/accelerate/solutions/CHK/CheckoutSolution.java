package io.accelerate.solutions.CHK;

import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CheckoutSolution {

    private static final Map<Character, Integer> PRICES = Map.of(
            'A', 50,
            'B', 30,
            'C', 20,
            'D', 15
    );

    private static final Map<Character, int[]> PROMOTIONS = Map.of(
            'A', new int[]{3, 130},
            'B', new int[]{2, 45}
    );

    private static final String VALID_ITEMS_REGEX = "[" +
            PRICES.keySet().
                    stream().
                    map(String::valueOf).
                    collect(Collectors.joining()) + "]";

    private static final Pattern VALID_ITEMS_PATTERN = Pattern.compile(VALID_ITEMS_REGEX);

    public Integer checkout(String skus) {
        if (skus == null || skus.isBlank() || !VALID_ITEMS_PATTERN.matcher(skus.trim()).find()) {
            return -1;
        }

        for (char c : skus.toCharArray()) {
            if (PRICES.containsKey(c)) {

            }
        }
    }
}



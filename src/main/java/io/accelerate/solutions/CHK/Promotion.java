package io.accelerate.solutions.CHK;

import java.util.Map;

public abstract class Promotion {
    abstract int[] apply(int quantity, Map<Character, Integer> checkOutItems);
    abstract int getPromo();
}


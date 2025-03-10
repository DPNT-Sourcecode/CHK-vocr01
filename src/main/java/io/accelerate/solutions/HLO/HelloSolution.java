package io.accelerate.solutions.HLO;

/**
 * The Hello solution class.
 */
public class HelloSolution {
    /**
     * Returns a sentence containing the friend's name
     * (if it is not null or empty, otherwise returns "Hello World!" sentence).
     *
     * @param friendName the friend name
     * @return the sentence with the friend's name.
     */
    public String hello(String friendName) {
        if (friendName == null || friendName.isBlank()) {
            return "Hello, World!";
        }
        return "Hello, " + friendName + "!";
    }
}


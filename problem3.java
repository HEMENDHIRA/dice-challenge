import java.util.HashMap;
import java.util.Map;

public class DiceProbability {

    public static void main(String[] args) {
        int sides = 6;
        calculateAndDisplayProbability(sides);
    }

    private static void calculateAndDisplayProbability(int sides) {
        Map<Integer, Integer> distribution = new HashMap<>();

        // Count occurrences of each sum
        for (int die1 = 1; die1 <= sides; die1++) {
            for (int die2 = 1; die2 <= sides; die2++) {
                int sum = die1 + die2;
                distribution.put(sum, distribution.getOrDefault(sum, 0) + 1);
            }
        }

        int totalCombinations = sides * sides; // Total number of combinations
        System.out.println("Probability of Each Sum:");

        // Calculate and display the probability for each sum
        for (Map.Entry<Integer, Integer> entry : distribution.entrySet()) {
            int sum = entry.getKey();
            int combinations = entry.getValue();
            double probability = (double) combinations / totalCombinations;

            System.out.println("P(Sum = " + sum + ") = " + "1/" + totalCombinations / combinations +
                    " = " + String.format("%.4f", probability));
        }
    }
}

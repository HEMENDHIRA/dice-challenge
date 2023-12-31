import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int sides = 6;
        displayDiceDistribution(sides);
    }

    public static void displayDiceDistribution(int sides) {
        Map<Integer, Integer> distribution = new HashMap<>();

        for (int die1 = 1; die1 <= sides; die1++) {
            for (int die2 = 1; die2 <= sides; die2++) {
                int sum = die1 + die2;
                distribution.put(sum, distribution.getOrDefault(sum, 0) + 1);
            }
        }

        System.out.println("Distribution of Sum of Dice:");
        for (Map.Entry<Integer, Integer> entry : distribution.entrySet()) {
            System.out.println("Sum " + entry.getKey() + ": " + entry.getValue() + " combinations");
        }
    }
}

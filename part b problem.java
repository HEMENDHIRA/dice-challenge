import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<Integer, Double> getProbabilities(int[] dieFaces) {
        Map<Integer, Double> probabilities = new HashMap<>();
        calculateProbabilities(dieFaces, 0, 0, probabilities);
        int totalOutcomes = (int) Math.pow(dieFaces.length, dieFaces.length);
        for (Map.Entry<Integer, Double> entry : probabilities.entrySet()) {
            probabilities.put(entry.getKey(), entry.getValue() / totalOutcomes);
        }
        return probabilities;
    }

    public static void calculateProbabilities(int[] dieFaces, int index, int currentSum, Map<Integer, Double> probabilities) {
        if (index == dieFaces.length) {
            probabilities.put(currentSum, probabilities.getOrDefault(currentSum, 0.0) + 1);
        } else {
            for (int face : dieFaces) {
                calculateProbabilities(dieFaces, index + 1, currentSum + face, probabilities);
            }
        }
    }

    public static int[] undoomDice(int[] dieA, int[] dieB) {
 
        Map<Integer, Double> originalProbabilitiesA = getProbabilities(dieA);
        Map<Integer, Double> originalProbabilitiesB = getProbabilities(dieB);

       
        Double targetProbabilitySum2 = originalProbabilitiesA.get(2);
        if (targetProbabilitySum2 == null) {
            throw new IllegalArgumentException("Invalid input: P(Sum = 2) for dieA is not defined.");
        }

        Map<Integer, Double> targetProbabilitiesA = new HashMap<>();
        for (int face : originalProbabilitiesA.keySet()) {
            Double originalProbability = originalProbabilitiesA.get(face);
            if (originalProbability != null) {
                targetProbabilitiesA.put(face, originalProbability * targetProbabilitySum2);
            }
        }

  
        int[] newDieA = new int[dieA.length];
        for (int i = 0; i < dieA.length; i++) {
            int face = dieA[i];
            Double originalProbability = originalProbabilitiesA.get(face);

            for (int newFace : dieA) {
                Double targetProbability = targetProbabilitiesA.get(newFace);
                if (newFace <= 4 && originalProbability != null && targetProbability != null && originalProbability * targetProbabilitySum2 == targetProbability) {
                    newDieA[i] = newFace;
                    break;
                }
            }
        }

    
        int[] newDieB = Arrays.copyOf(dieB, dieB.length);

        return newDieA;
    }

    public static void main(String[] args) {
        int[] dieA = {1, 2, 3, 4, 5, 6};
        int[] dieB = {1, 2, 3, 4, 5, 6};
        int[] newDieA = undoomDice(dieA, dieB);

        System.out.println("New_Die_A: " + Arrays.toString(newDieA));
        System.out.println("New_Die_B: " + Arrays.toString(dieB));
    }
}

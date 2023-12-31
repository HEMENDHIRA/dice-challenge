public class Main{
    public static void main(String[] args) {
        int sides = 6;
        printDiceCombinations(sides);
    }

    public static void printDiceCombinations(int sides) {
        int count=0;
        for (int die1 = 1; die1 <= sides; die1++) {
            for (int die2 = 1; die2 <= sides; die2++) {
                count++;
            }
        }
        System.out.println("Cominations:"+count);
    }

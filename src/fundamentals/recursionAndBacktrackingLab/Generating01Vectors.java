package fundamentals.recursionAndBacktrackingLab;

import java.util.Scanner;

public class Generating01Vectors {
    public static void main(String[] args) {
        int n = Integer.parseInt(new Scanner((System.in)).nextLine());

        int[] vector = new int[n];

        generateVector(vector, 0);
    }

    private static void generateVector(int[] vector, int index) {
        if (index >= vector.length) {
            printVector(vector);
            return;
        }

        for (int i = 0; i <= 1; i++) {
            vector[index] = i;
            generateVector(vector, index + 1);
        }
    }

    private static void printVector(int[] vector) {
        for (int element : vector) {
            System.out.print(element);
        }
        System.out.println();
    }
}

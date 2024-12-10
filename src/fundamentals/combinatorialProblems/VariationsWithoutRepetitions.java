package fundamentals.combinatorialProblems;

import java.util.Scanner;

public class VariationsWithoutRepetitions {
    private static String[] elements;
    private static String[] kSlots;
    private static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");
        kSlots = new String[Integer.parseInt(scanner.nextLine())];
        used = new boolean[elements.length];

        variations(0);
    }

    private static void variations(int index) {
        if (index == kSlots.length) {
            print();
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            if (!used[i]) {
                used[i] = true;
                kSlots[index] = elements[i];
                variations(index + 1);
                used[i] = false;
            }
        }
    }

    private static void print() {
        System.out.println(String.join(" ", kSlots));
    }
}

package fundamentals.combinatorialProblemsLab;

import java.util.Scanner;

public class CombinationsWithoutRepetitions {
    private static String[] elements;
    private static String[] kSlots;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");
        kSlots = new String[Integer.parseInt(scanner.nextLine())];

        combinations(0, 0);
    }

    private static void combinations(int index, int start) {
        if (index == kSlots.length) {
            print();
            return;
        }

        for (int i = start; i < elements.length; i++) {
            kSlots[index] = elements[i];
            combinations(index + 1, i + 1);
        }
    }

    private static void print() {
        System.out.println(String.join(" ", kSlots));
    }
}

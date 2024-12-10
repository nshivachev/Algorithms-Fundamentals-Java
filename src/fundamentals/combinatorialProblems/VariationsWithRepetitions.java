package fundamentals.combinatorialProblems;

import java.util.Scanner;

public class VariationsWithRepetitions {
    private static String[] elements;
    private static String[] kSlots;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");
        kSlots = new String[Integer.parseInt(scanner.nextLine())];

        variations(0);
    }

    private static void variations(int index) {
        if (index == kSlots.length) {
            print();
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            kSlots[index] = elements[i];
            variations(index + 1);
        }
    }

    private static void print() {
        System.out.println(String.join(" ", kSlots));
    }
}

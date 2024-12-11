package fundamentals.recursionAndCombinatorialEx;

import java.util.Scanner;

public class ReverseArray {
    private static String[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        arr = scanner.nextLine().split("\\s+");

        reverseArray(0);
    }

    private static void reverseArray(int index) {
        if (index >= arr.length) {
            return;
        }

        reverseArray(index + 1);
        System.out.print(arr[index] + " ");
    }
}

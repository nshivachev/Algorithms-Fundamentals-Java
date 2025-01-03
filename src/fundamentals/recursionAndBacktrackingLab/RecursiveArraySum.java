package fundamentals.recursionAndBacktrackingLab;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(sum(arr, 0));
    }

    public static int sum(int[] numbers, int index) {
        if (index == numbers.length - 1) {
            return numbers[index];
        }

        return numbers[index] + sum(numbers, index + 1);
    }
}

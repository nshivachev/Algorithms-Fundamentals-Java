package fundamentals.recursionAndBacktrackingLab;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class RecursiveFibonacci {
    private static Map<Integer, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(getFibonacci(n));
    }

    private static long getFibonacci(int n) {
        if (n <= 1) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        long result = getFibonacci(n - 1) + getFibonacci(n - 2);
        memo.put(n, result);

        return result;
    }
}

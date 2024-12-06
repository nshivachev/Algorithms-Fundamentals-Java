package fundamentals.recursionAndBacktrackingLab;

import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        int n = Integer.parseInt(new Scanner(System.in).nextLine());

        System.out.println(factorial(n));
    }

    private static long factorial(int n) {
        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}

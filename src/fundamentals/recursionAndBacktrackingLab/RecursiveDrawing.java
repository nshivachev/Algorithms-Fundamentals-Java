package fundamentals.recursionAndBacktrackingLab;

import java.util.Scanner;

public class RecursiveDrawing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        printFigure(num);
    }

    private static void printFigure(int n) {
        if (n == 0) {
            return;
        }

        for (int i = n; i >= 1; i--) {
            System.out.print("*");
        }

        System.out.println();

        printFigure(n - 1);

        for (int i = 1; i <= n; i++) {
            System.out.print("#");
        }

        System.out.println();
    }
}

package fundamentals.recursionAndCombinatorialEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CombinationsWithRepetition {
    private static int[] slots;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        slots = new int[Integer.parseInt(br.readLine())];

        combinations(0, 1);
    }

    private static void combinations(int index, int start) {
        if (index >= slots.length) {
            printArr();
            return;
        }

        for (int i = start; i <= n; i++) {
            slots[index] = i;
            combinations(index + 1, i);
        }
    }

    private static void printArr() {
        Arrays.stream(slots).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}

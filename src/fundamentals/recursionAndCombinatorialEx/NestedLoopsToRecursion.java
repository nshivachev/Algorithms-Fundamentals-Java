package fundamentals.recursionAndCombinatorialEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NestedLoopsToRecursion {
    private static int[] arr;
    private static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];

        perm(0);

        System.out.println(output.toString());
    }

    private static void perm(int index) {
        if (index >= arr.length) {
            Arrays.stream(arr).forEach(el -> output.append(el).append(" "));
            output.append(System.lineSeparator());
            return;
        }

        for (int i = 1; i <= arr.length; i++) {
            arr[index] = i;
            perm(index + 1);
        }
    }
}

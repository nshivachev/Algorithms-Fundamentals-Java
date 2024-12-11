package fundamentals.recursionAndCombinatorialEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

public class TowerOfHanoi {
    private static Deque<Integer> source = new ArrayDeque<>();
    private static Deque<Integer> spare = new ArrayDeque<>();
    private static Deque<Integer> destination = new ArrayDeque<>();

    private static StringBuilder out = new StringBuilder();

    private static int steps = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfDisks = Integer.parseInt(br.readLine());

        for (int i = numberOfDisks; i >= 1; i--) {
            source.push(i);
        }

        printRoads();
        solve(numberOfDisks, source, destination, spare);

        System.out.println(out.toString());
    }

    private static void solve(int numberOfDisks, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        if (numberOfDisks == 1) {
            destination.push(source.pop());

            out.append("Step #").append(steps++)
                    .append(": Moved disk")
                    .append(System.lineSeparator());

            printRoads();

            return;
        }

        solve(numberOfDisks - 1, source, spare, destination);
        solve(1, source, destination, spare);
        solve(numberOfDisks - 1, spare, destination, source);
    }

    private static void printRoads() {
        out.append(String.format("Source: %s%nDestination: %s%nSpare: %s%n",
                        formatRoad(source), formatRoad(destination), formatRoad(spare)))
                .append(System.lineSeparator());
    }

    private static String formatRoad(Deque<Integer> stack) {
        return stack.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf).collect(Collectors.joining(", "));
    }
}

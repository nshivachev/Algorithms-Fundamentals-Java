package fundamentals.recursionAndCombinatorialEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectedAreasInAMatrix {
    private static char[][] matrix;
    private static List<int[]> coordinates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(br.readLine());
        int cols = Integer.parseInt(br.readLine());

        matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = br.readLine().toCharArray();
        }

        coordinates = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == '-') {
                    coordinates.add(new int[]{r, c, 0});
                    findPath(r, c);
                }
            }
        }

        System.out.println("Total areas found: " + coordinates.size());

        AtomicInteger counter = new AtomicInteger(1);

        coordinates.stream()
                .sorted((f, s) -> Integer.compare(s[2], f[2]))
                .forEach(c ->
                        System.out.println("Area #" + counter.getAndIncrement()
                        + " at (" + c[0] + ", " + c[1] + "), size: " + c[2]));
    }

    private static void findPath(int row, int col) {
        if (!isInBounds(row, col)
                || matrix[row][col] == 'V'
                || matrix[row][col] == '*') {

            return;
        }

        matrix[row][col] = 'V';

        coordinates.get(coordinates.size() - 1)[2]++;

        findPath(row - 1, col);
        findPath(row + 1, col);
        findPath( row, col - 1);
        findPath( row, col + 1);
    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}

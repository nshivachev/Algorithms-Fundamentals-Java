package fundamentals.searchingSortingAndGreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int element : mergeSort(arr)) {
            System.out.print(element + " ");
        }
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int halfIndex = arr.length / 2;

        int firstArrLength = halfIndex;
        int secondArrLength = arr.length - halfIndex;

        int[] firstPartition = new int[firstArrLength];
        int[] secondPartition = new int[secondArrLength];

        for (int i = 0; i < firstArrLength; i++) {
            firstPartition[i] = arr[i];
        }

        for (int i = 0; i < secondArrLength; i++) {
            secondPartition[i] = arr[halfIndex + i];
        }

        firstPartition = mergeSort(firstPartition);
        secondPartition = mergeSort(secondPartition);

        int mainIndex = 0;

        int firstPartitionIndex = 0;
        int secondPartitionIndex = 0;

        while (firstPartitionIndex < firstArrLength && secondPartitionIndex < secondArrLength) {
            if (firstPartition[firstPartitionIndex] < secondPartition[secondPartitionIndex]) {
                arr[mainIndex] = firstPartition[firstPartitionIndex];

                mainIndex++;
                firstPartitionIndex++;
            } else {
                arr[mainIndex] = secondPartition[secondPartitionIndex];

                mainIndex++;
                secondPartitionIndex++;
            }
        }

        while (firstPartitionIndex < firstArrLength) {
            arr[mainIndex] = firstPartition[firstPartitionIndex];

            mainIndex++;
            firstPartitionIndex++;
        }

        while (secondPartitionIndex < secondArrLength) {
            arr[mainIndex] = secondPartition[secondPartitionIndex];

            mainIndex++;
            secondPartitionIndex++;
        }

        return arr;
    }
}

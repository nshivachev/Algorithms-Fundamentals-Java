package fundamentals.recursionAndCombinatorialEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class WordCruncher {
    private static List<String> initialWords;
    private static String targetText;
    private static List<String> crunchedWords;
    private static Set<String> out;
    public static Map<Integer, List<String>> table;
    private static Map<String, Integer> occurrences;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        initialWords = Arrays.stream(br.readLine().split(", ")).collect(Collectors.toList());
        targetText = br.readLine();

        initialWords.removeIf(w -> !targetText.contains(w));

        crunchedWords = new ArrayList<>();
        out = new TreeSet<>();
        table = new HashMap<>();
        occurrences = new HashMap<>();

        for (String subtext : initialWords) {
            occurrences.putIfAbsent(subtext, 0);
            occurrences.put(subtext, occurrences.get(subtext) + 1);
            int index = targetText.indexOf(subtext);
            while (index != -1) {
                table.putIfAbsent(index, new ArrayList<>());
                table.get(index).add(subtext);
                index = targetText.indexOf(subtext, index + 1);
            }
        }

        crunch(0);

        for (String text : out) {
            System.out.println(text);
        }
    }

    private static void crunch(int index) {
        if (index == targetText.length()) {
            print();
            return;
        }

        if (table.containsKey(index)) {
            List<String> texts = table.get(index);
            for (String text : texts) {
                if (occurrences.get(text) > 0) {
                    occurrences.put(text, occurrences.get(text) - 1);
                    crunchedWords.add(text);
                    crunch(index + text.length());
                    crunchedWords.remove(crunchedWords.size() - 1);
                    occurrences.put(text, occurrences.get(text) + 1);
                }
            }
        }
    }

    private static void print() {
        String actualText = String.join("", crunchedWords);
        if (actualText.contains(targetText)) {
            out.add(String.join(" ", crunchedWords));
        }
    }
}

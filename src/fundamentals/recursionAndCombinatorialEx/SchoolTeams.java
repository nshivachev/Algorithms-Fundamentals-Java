package fundamentals.recursionAndCombinatorialEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SchoolTeams {
    private static String[] girls;
    private static String[] boys;
    private static String[] girlsSingleTeam;
    private static String[] boysSingleTeam;
    private static List<String> girlsAllTeams;
    private static List<String> boysAllTeams;
    private static StringBuilder output;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        girls = br.readLine().split(", ");
        boys = br.readLine().split(", ");
        girlsSingleTeam = new String[3];
        boysSingleTeam = new String[2];
        girlsAllTeams = new ArrayList<>();
        boysAllTeams = new ArrayList<>();
        output = new StringBuilder();

        combineGirls(0, 0);
        combineBoys(0, 0);

        storeTeams();

        System.out.println(output.toString().trim());
    }

    private static void combineGirls(int index, int start) {
        if (index >= girlsSingleTeam.length) {
            girlsAllTeams.add(String.join(", ", girlsSingleTeam));
            return;
        }

        for (int i = start; i < girls.length; i++) {
            girlsSingleTeam[index] = girls[i];
            combineGirls(index + 1, i + 1);
        }
    }

    private static void combineBoys(int index, int start) {
        if (index >= boysSingleTeam.length) {
            boysAllTeams.add(String.join(", ", boysSingleTeam));
            return;
        }

        for (int i = start; i < boys.length; i++) {
            boysSingleTeam[index] = boys[i];
            combineBoys(index + 1, i + 1);
        }
    }

    private static void storeTeams() {
        girlsAllTeams.forEach(girlTeam ->
                boysAllTeams.forEach(boyTeam ->
                        output.append(girlTeam)
                                .append(", ")
                                .append(boyTeam)
                                .append(System.lineSeparator())));
    }
}

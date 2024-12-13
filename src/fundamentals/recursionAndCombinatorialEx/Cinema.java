package fundamentals.recursionAndCombinatorialEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cinema {
    private static StringBuilder output;
    private static String[] allFriends;
    private static List<String> friendsWithoutReservation;
    private static String[] notReservedSeats;
    private static Map<Integer, String> reservedSeats;
    private static String[] finalSeats;
    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        output = new StringBuilder();

        String input = br.readLine();

        allFriends = input.split(", ");

        friendsWithoutReservation = new ArrayList<>();

        reservedSeats = new HashMap<>();

        while (!"generate".equals(input = br.readLine())) {
            String[] tokens = input.split(" - ");
            reservedSeats.putIfAbsent(Integer.parseInt(tokens[1]), tokens[0]);
        }

        Arrays.stream(allFriends).forEach(friend -> {
            if (!reservedSeats.containsValue(friend)) {
                friendsWithoutReservation.add(friend);
            }
        });

        notReservedSeats = new String[friendsWithoutReservation.size()];

        finalSeats = new String[allFriends.length];

        reservedSeats.forEach((seat, friend) -> finalSeats[seat - 1] = friend);

        used = new boolean[friendsWithoutReservation.size()];

        distributeFriendsIntoSeats(0);

        System.out.println(output.toString().trim());
    }

    private static void distributeFriendsIntoSeats(int index) {
        if (index == friendsWithoutReservation.size()) {
            print();
            return;
        }

        for (int i = 0; i < friendsWithoutReservation.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                notReservedSeats[index] = friendsWithoutReservation.get(i);
                distributeFriendsIntoSeats(index + 1);
                used[i] = false;
            }
        }
    }

    private static void print() {
        int j = 0;
        for (int i = 0; i < finalSeats.length; i++) {
            if (!reservedSeats.containsValue(finalSeats[i])) {
                finalSeats[i] = notReservedSeats[j++];
            }
        }

        output.append(String.join(" ", finalSeats)).append(System.lineSeparator());
    }
}
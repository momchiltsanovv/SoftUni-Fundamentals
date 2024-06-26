package MidExam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> playlist = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        byte n = Byte.parseByte(scanner.nextLine());

        for (int i = 0; i < n; ++i) {
            String[] commands = scanner.nextLine().split(" ");
            switch (commands[0]) {
                case "Add" -> {
                    if(playlist.contains(commands[3])) {
                        continue;
                    }
                    playlist.add(commands[3]);
                    System.out.printf("%s successfully added\n", commands[3]);
                }
                case "Delete" -> {
                    int numberOfSongs = Integer.parseInt(commands[3]);
                    if (numberOfSongs > playlist.size()) {
                        continue;
                    }
                    boolean first = true;
                    for (int j = 0; j < numberOfSongs; ++j) {
                        if (!first) {
                            System.out.print(", ");
                        } else {
                            first = false;
                        }
                        System.out.print(playlist.get(j));
                    }
                    System.out.println(" deleted");
                    playlist.subList(0, numberOfSongs).clear();
                }
                case "Shuffle" -> {
                    int idx1 = Integer.parseInt(commands[3]);
                    int idx2 = Integer.parseInt(commands[5]);
                    if (idx1 >= 0 && idx1 < playlist.size() && idx2 >= 0 && idx2 < playlist.size()) {
                        Collections.swap(playlist, idx1, idx2);
                    } else {
                        continue;
                    }
                    System.out.printf("%s is swapped with %s\n", playlist.get(idx1), playlist.get(idx2));
                }
                case "Insert" -> {
                    String songToInsert = commands[2];
                    int idx = Integer.parseInt(commands[4]);
                    if (idx >= 0 && idx < playlist.size()) {
                        if (playlist.contains(songToInsert)) {
                            System.out.println("Song is already in the playlist");
                            continue;
                        }
                        playlist.add(idx, songToInsert);
                        System.out.printf("%s successfully inserted\n", commands[2]);
                    } else {
                        System.out.println("Index out of range");
                    }
                }
                case "Sort" -> {
                    Collections.sort(playlist);
                    Collections.reverse(playlist);
                }
                case "Play" -> {
                    System.out.println("Songs to Play:");
                    for(String song : playlist) {
                        System.out.println(song);
                    }
                }

            }
        }

    }
}

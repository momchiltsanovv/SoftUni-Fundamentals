package Exam;

import java.util.*;

import static java.lang.System.in;

public class Exercise_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        Map<String, List<Integer>> followers = new LinkedHashMap<>();

        String[] command = sc.nextLine().split(": ");

        while (!command[0].equals("Log out")) {

            switch (command[0]) {

                case "New follower" -> {
                    String username = command[1];
                    followers.putIfAbsent(username, new ArrayList<>(Arrays.asList(0, 0)));
                }
                case "Like" -> {
                    String username = command[1];
                    int count = Integer.parseInt(command[2]);
                    followers.putIfAbsent(username, new ArrayList<>(Arrays.asList(0, 0)));
                    int newCount = count + followers.get(username).get(0);
                    followers.get(username).set(0, newCount);
                }
                case "Comment" -> {
                    String username = command[1];
                    followers.putIfAbsent(username, new ArrayList<>(Arrays.asList(0, 0)));
                    int newCount = followers.get(username).get(1) + 1;
                    followers.get(username).set(1, newCount);
                }
                case "Blocked" -> {
                    String username = command[1];
                    if (!followers.containsKey(username)) {
                        System.out.printf("%s doesn't exist.%n", username);
                    } else {
                        followers.remove(username);
                    }
                }
            }
            command = sc.nextLine().split(": ");
        }

        System.out.printf("%d followers\n", followers.size());
        for (Map.Entry<String, List<Integer>> entry : followers.entrySet()) {
            List<Integer> followerList = entry.getValue();
            System.out.printf("%s: %d\n", entry.getKey(), followerList.get(0) + followerList.get(1));
        }

    }
}

package ExamPrep;

import java.util.*;

import static java.lang.System.in;

public class ThePianist {

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int pieces = Integer.parseInt(sc.nextLine());

        Map<String, List<String>> piecesList = new LinkedHashMap<>();

        for (int i = 0; i < pieces; i++) {
            String[] input = sc.nextLine().split("\\|");
            String name = input[0];
            String piece = input[1];
            String pieceKey = input[2];
            piecesList.put(name, Arrays.asList(piece, pieceKey));
        }

        String[] commands = sc.nextLine().split("\\|");
        while (!commands[0].equals("Stop")) {
            String firstCommand = commands[0];
            switch (firstCommand) {
                case "Add" -> add(commands, piecesList);

                case "Remove" -> remove(commands, piecesList);

                case "ChangeKey" -> changeKey(commands, piecesList);
            }

            commands = sc.nextLine().split("\\|");
        }

        printResult(piecesList);

    }

    public static void printResult(Map<String, List<String>> piecesList) {
        for (Map.Entry<String, List<String>> entry : piecesList.entrySet()) {
            List<String> pieceList = entry.getValue();
            System.out.printf("%s -> Composer: %s, Key: %s\n", entry.getKey(), pieceList.get(0), pieceList.get(1));
        }
    }

    public static void add(String[] commands, Map<String, List<String>> piecesList) {
        String pieceName = commands[1];
        String pieceMaker = commands[2];
        String pieceKey = commands[3];

        if (piecesList.containsKey(pieceName)) {
            System.out.printf("%s is already in the collection!\n", pieceName);
        } else {
            piecesList.putIfAbsent(pieceName, Arrays.asList(pieceMaker, pieceKey));
            System.out.printf("%s by %s in %s added to the collection!\n", pieceName, pieceMaker, pieceKey);
        }
    }

    public static void remove(String[] commands, Map<String, List<String>> piecesList) {
        String pieceName = commands[1];
        if (piecesList.containsKey(pieceName)) {
            piecesList.remove(pieceName);
            System.out.printf("Successfully removed %s!\n", pieceName);
        } else {
            System.out.printf("Invalid operation! %s does not exist in the collection.\n", pieceName);
        }
    }

    public static void changeKey(String[] commands, Map<String, List<String>> piecesList) {
        String pieceName = commands[1];
        String newPieceKey = commands[2];
        if (piecesList.containsKey(pieceName)) {
            piecesList.get(pieceName).set(1, newPieceKey);
            System.out.printf("Changed the key of %s to %s!\n", pieceName, newPieceKey);
        } else {
            System.out.printf("Invalid operation! %s does not exist in the collection.\n", pieceName);
        }
    }
}

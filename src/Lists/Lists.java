package Lists;

import java.util.*;
import java.util.stream.Collectors;

public class Lists {
    public static void main(String[] args) {
        anonymousThreat();
    }

    public static void train() {
        Scanner scanner = new Scanner(System.in);

        List<Short> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Short::parseShort).collect(Collectors.toList());

        short wagonCapacity = Short.parseShort(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] commandType = command.split(" ");

            if (commandType[0].equals("Add")) {
                short adding = Short.parseShort(commandType[1]);
                wagons.add(adding);
            } else {
                Short passengersToAdd = Short.parseShort(commandType[0]);

                for (short i = 0; i < wagons.size(); ++i) {
                    if (wagons.get(i) + passengersToAdd <= wagonCapacity) {
                        wagons.set(i, (short) (wagons.get(i) + passengersToAdd));
                        break;
                    }
                }
            }
            command = scanner.nextLine();
        }
        for (short wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }

    public static void changeList() {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listToManipulate = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());


        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] commandType = command.split(" ");
            if (commandType[0].equals("Delete")) {
                int numToRemove = Integer.parseInt(commandType[1]);
                for (int i = 0; i < listToManipulate.size(); ++i) { // deleting all occurrences of the given element
                    if (numToRemove == listToManipulate.get(i)) {
                        listToManipulate.remove(i);
                    }
                }
            } else if (commandType[0].equals("Insert")) {
                int number = Integer.parseInt(commandType[1]);
                int atIndex = Integer.parseInt(commandType[2]);
                listToManipulate.add(atIndex, number);
            }

            command = scanner.nextLine();
        }

        for (int wagon : listToManipulate) {
            System.out.print(wagon + " ");
        }
    }

    public static void houseParty() {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        List<String> names = new ArrayList<>();
        for (int i = 0; i < lines; ++i) {
            String[] inputLine = scanner.nextLine().split(" ");

            if (inputLine[2].equals("going!")) {
                if (names.contains(inputLine[0])) {
                    System.out.printf("%s is already in the list!\n", inputLine[0]);
                    continue;
                }
                names.add(inputLine[0]);
            } else if (inputLine[2].equals("not")) {
                if (!names.contains(inputLine[0])) {
                    System.out.printf("%s is not in the list!\n", inputLine[0]);
                }
                names.remove(inputLine[0]);
            }
        }

        for (String name : names) {
            System.out.println(name);
        }
    }

    public static void listOperations() {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());


        String[] command = scanner.nextLine().split(" ");

        while (!command[0].equals("End")) {

            int sizeArr = command.length;

            String curCom = command[0];
            if (sizeArr == 2) {
                switch (curCom) {
                    case "Add" -> {
                        int num = Integer.parseInt(command[1]);
                        input.add(num);
                    }
                    case "Remove" -> {
                        int idx = Integer.parseInt(command[1]);
                        if (idx >= input.size() || idx < 0) {
                            System.out.println("Invalid index");
                            command = scanner.nextLine().split(" ");
                            continue;
                        }
                        input.remove(idx);
                    }
                }
            } else {
                switch (curCom) {
                    case "Insert" -> {
                        int number = Integer.parseInt(command[1]);
                        int atIndex = Integer.parseInt(command[2]);
                        if (atIndex >= input.size() || atIndex < 0) {
                            System.out.println("Invalid index");
                            command = scanner.nextLine().split(" ");
                            continue;
                        }
                        input.add(atIndex, number);
                    }
                    case "Shift" -> {
                        int timesShift = Integer.parseInt(command[2]);
                        if (command[1].equals("right")) {
                            Collections.rotate(input, timesShift);
                        } else {
                            Collections.rotate(input, -timesShift); // -times to shift the other way
                        }
                    }
                }
            }
            command = scanner.nextLine().split(" ");
        }

        for (int num : input)
            System.out.print(num + " ");

    }

    public static void bombNumbers() {
        Scanner scanner = new Scanner(System.in);


        List<Integer> input = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String[] command = scanner.nextLine().split(" ");
        int bombNum = Integer.parseInt(command[0]);
        int sqrtBombNum = Integer.parseInt(command[1]);

        while (input.contains(bombNum)) {
            int elementIndex = input.indexOf(bombNum);

            int left = Math.max(0, elementIndex - sqrtBombNum);
            int right = Math.min(elementIndex + sqrtBombNum, input.size() - 1);

            if (right >= left) {
                input.subList(left, right + 1).clear(); // + 1 becuase the subList func is from index inclusive to index exclusive
            }
        }

        int sum = 0;
        for (int num : input) {
            sum += num;
        }
        System.out.println(sum);
    }

    public static void cardsGame() {
        Scanner scanner = new Scanner(System.in);


        List<Integer> playerOne = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> playerTwo = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (!playerOne.isEmpty() && !playerTwo.isEmpty()) {
            int firstPlayerCard = playerOne.get(0);
            int secondPlayerCard = playerTwo.get(0);
            playerOne.remove(0);
            playerTwo.remove(0);

            if (secondPlayerCard > firstPlayerCard) {
                playerTwo.add(secondPlayerCard);
                playerTwo.add(firstPlayerCard);
            } else if (secondPlayerCard < firstPlayerCard) {
                playerOne.add(firstPlayerCard);
                playerOne.add(secondPlayerCard);
            }
        }
        if (playerOne.isEmpty()) {
            //second wins -> sum of card of second player
            System.out.printf("Second player wins! Sum: %d", getCardsSum(playerTwo));
        } else {
            //first wins
            System.out.printf("First player wins! Sum: %d", getCardsSum(playerOne));
        }
    }

    public static int getCardsSum(List<Integer> cards) {
        int sum = 0;
        for (int card : cards) {
            sum += card;
        }
        return sum;
    }

    public static void appendArrays() {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> list = Arrays.stream(input.split("\\|")).collect(Collectors.toList());

        Collections.reverse(list);

        System.out.println(list.toString()
                .replace("[", "")
                .replace("]", "")
                .trim()
                .replaceAll(",", "")
                .replaceAll("\\s+", " "));
    }

    public static void anonymousThreat() {
        Scanner scanner = new Scanner(System.in);

        List<String> texts = Arrays.stream(scanner.nextLine().split("\\s+")) //["Ivo", "Johny", "Tony", "Bony", "Mony"]
                .collect(Collectors.toList()); //{"Ivo", "Johny", "Tony", "Bony", "Mony"}

        String command = scanner.nextLine();

        while (!command.equals("3:1")) {
            if (command.contains("merge")) {
                //command = "merge {startIndex} {endIndex}"
                int startIndex = Integer.parseInt(command.split(" ")[1]);
                int endIndex = Integer.parseInt(command.split(" ")[2]);

                //checking startIndex
                if (startIndex < 0) {
                    startIndex = 0;
                }

                //checking за endIndex
                if (endIndex > texts.size() - 1) {
                    endIndex = texts.size() - 1;
                }

                //valid indexes -> [0, дълж - 1]
                if (startIndex >= 0 && startIndex <= texts.size() - 1 && endIndex >= 0 && endIndex <= texts.size() - 1) {
                    //{"Ivo", "Johny", "Tony", "Bony", "Mony"}
                    //merge 1 3
                    //concatenating
                    String resultMerge = "";
                    for (int index = startIndex; index <= endIndex; index++) {
                        String current = texts.get(index);
                        resultMerge += current;
                    }

                    //resulMerge = "JohnyTonyBony"
                    //removing merged elements
                    texts.subList(startIndex, endIndex + 1).clear();
                    //{"Ivo", "Mony"}

                    //adding the result merge in startIndex
                    texts.add(startIndex, resultMerge);
                    //{"Ivo", "JohnyTonyBony", "Mony"}
                }
            } else if (command.contains("divide")) {
                //command = "divide {index} {partitions}"
                int index = Integer.parseInt(command.split(" ")[1]);
                int parts = Integer.parseInt(command.split(" ")[2]); //count of parts

                //validating the index, from which we are going to take text
                if (index >= 0 && index <= texts.size() - 1) {
                    //{"abcdef", "ghi", "jkl"}
                    //divide 0 3
                    String textForDivide = texts.get(index); //"abcdef"
                    texts.remove(index);
                    //{"ghi", "jkl"}

                    //1. Count of symbols for every part
                    int countSymbolsPerPart = textForDivide.length() / parts;

                    //all equal parts except last one
                    int beginIndex = 0; //index in the text for dividing
                    for (int part = 1; part < parts; part++) {
                        String textPerPart = textForDivide.substring(beginIndex, beginIndex + countSymbolsPerPart);
                        texts.add(index, textPerPart);
                        index++; //place of placing the shattered part in main list
                        beginIndex += countSymbolsPerPart;
                    }

                    //last part
                    String textLastParts = textForDivide.substring(beginIndex, textForDivide.length());
                    texts.add(index, textLastParts);
                }

            }


            command = scanner.nextLine();
        }

        //!!!!printing list with texts -> String.join!!!
        System.out.println(String.join(" ", texts));

        /* or
        for (String text : texts) {
            System.out.print(text + " ");
        }
        */
    }
}
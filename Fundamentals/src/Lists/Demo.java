package Lists;


import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> number = parseIntegersList(scanner);
        String input = scanner.nextLine();

        for (int i = 0; i < number.size(); i++) {
            String output = "";
            int currentNum = number.get(i);
            int index = returenSumOfCurrentNum(currentNum);

            char currentChar = getCharFromInput(index, input);
            System.out.print(currentChar);

            for (int j = 0; j < input.length() - 1; j++) {
                    input += input.charAt(j);
                    if (currentChar == input.charAt(i)){

                    }
            }
            input = output;


        }


    }

    private static int calculateRealIndex(int index, String input) {
        int countIndex = 0;

        for (int i = 0; i < index; i++) {
            countIndex++;

            if (countIndex == input.length()) {
                countIndex = 0;
            }

        }
        return countIndex;
    }

    private static char getCharFromInput(int value, String input) {
        int countIndex = 0;
        for (int i = 0; i < value; i++) {
            countIndex++;

            if (countIndex == input.length()) {
                countIndex = 0;
            }

        }
        char currentChar = input.charAt(countIndex);
        return currentChar;
    }

    private static int returenSumOfCurrentNum(int currentNum) {
        int sum = 0;
        while (currentNum != 0) {
            int nextNum = currentNum % 10;
            sum += nextNum;
            currentNum -= nextNum;
            currentNum /= 10;
        }

        return sum;

    }

    private static void shift(List<Integer> numbers, String direction, int cout) {
        switch (direction) {
            case "right":
                for (int i = 0; i < cout; i++) {
                    int last = numbers.get(numbers.size() - 1);
                    numbers.remove(numbers.size() - 1);
                    numbers.add(0, last);
                }
                break;
            case "left":
                for (int i = 0; i < cout; i++) {
                    int first = numbers.get(0);
                    numbers.remove(0);
                    numbers.add(first);
                }
                break;
        }
    }


    //List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
    //                .map(Integer::parseInt).collect(Collectors.toList());


    private static List<Integer> parseIntegersList(Scanner scanner) {
        String line = scanner.nextLine();
        String[] numbersAsStrings = line.split(" ");

        List<Integer> numbers = new ArrayList<>();

        for (String s : numbersAsStrings) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }
        return numbers;
    }

    private static List<Double> parseDoubleList(Scanner scanner) {
        String[] input = scanner.nextLine().split(" ");
        List<Double> nums = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            double num = Double.parseDouble(input[i]);
            nums.add(num);

        }
        return nums;
    }
}

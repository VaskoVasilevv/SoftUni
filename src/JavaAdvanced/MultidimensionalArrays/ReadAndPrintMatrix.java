package JavaAdvanced.MultidimensionalArrays;

public class ReadAndPrintMatrix {

    /*
     private static int[] findIndexes(char[][] matrix, char toFind) {
        int[] indexes = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == toFind) {
                    indexes[0] = i;
                    indexes[1] = j;
                }
            }
        }
        return indexes;
    }

     IS IN BOUNDS
-------------------------------------------------------------------------------------------------------
    private static boolean indexesInBounds() {
        return (beeRow >= 0 && beeRow < matrix.length) && (beeCol >= 0 && beeCol < matrix[beeRow].length);
    }
------------------------------------------------------------------------------------------------------

     READ MATRIX:
-------------------------------------------------------------------------------------------------------
     Кофато матрицата и индексите са изнесени в калса

     private static void readMatrix(Scanner scan) {
        int n = Integer.parseInt(scan.nextLine());
        matrix = new char[n][n];
        for (int row = 0; row < matrix.length; row++) {
            String input = scan.nextLine();
            matrix[row] = input.toCharArray();
            if (input.contains("B")) {
                beeRow = row;
                beeCol = input.indexOf('B');
            }
        }
    }



    int [][]
    private static int[][] readMatrix(Scanner scanner) {
        int[] size = readArray(scanner);
        int[][] matrix = new int[size[0]][size[1]];
        for (int i = 0; i < size[0]; i++) {
            matrix[i] = readArray(scanner);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    char [][]
    private static char[][] readMatrix(Scanner scan) {
         int rows = ? ;
         int cols = ? ;
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < 8; row++) {
            matrix[row] = scan.nextLine()
                    .replaceAll("\\s+", "").toCharArray();
        }
        return matrix;
    }
    String [][]
    private static String[][] readMatrix(Scanner scan) {
        int[] size = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[size[0]][size[1]];
        for (int i = 0; i < size[0]; i++) {
            matrix[i] = scan.nextLine().split("\\s+");
        }
        return matrix;
    }
----------------------------------------------------------------------------------------------------------

     PRINT MATRIX:
-----------------------------------------------------------------------------------------------------------
    Arrays.stream(matrix).forEach(row ->{ Arrays.stream(row)
            .forEach(System.out::print); System.out.println(); });

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%d ", element);
            }
            System.out.println();
        }
    }
    private static void printMatrix(char[][] output) {
        for (char[] current : output) {
            IntStream.range(0, current.length).forEach(j -> System.out.printf("%c ", current[j]));
            System.out.println();
        }
    }
    private static void printMatrix(char[][] matrix) {
        Arrays.stream(matrix).map(row -> Arrays.toString(row).replaceAll("[\\[\\]]", "")
                .replaceAll(", ", "")).forEach(System.out::println);
    }


    STACK & QUEUE
-----------------------------------------------------------------------------------------------------

        //Stack
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(lilies::push);
        //Queue
        ArrayDeque<Integer> roses = Arrays.stream(scanner.nextLine()
                .split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

    PRINT
------------------------------------------------------------------------------
List<Integer>|| Stack || Queue
System.out.println(female.isEmpty() ? "Females left: none"
                :String.format("Females left: %s",female.stream().map(String::valueOf).collect(Collectors.joining(", "))));
    }
*/


}

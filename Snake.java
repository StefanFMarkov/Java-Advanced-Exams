import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];
        int neededFood = 10;
        int eatenFood = 0;

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().toCharArray();
        }

        int row = 0;
        int col = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'S') {
                    row = i;
                    col = j;
                }
            }
        }
        matrix[row][col] = '.';

        boolean isValidSnake = true;
        while (eatenFood < neededFood && isValidSnake) {
            String input = scan.nextLine();

            switch (input) {
                case "left":
                    col--;
                    if (isValid(matrix, row, col)) {
                        isValidSnake = false;
                        break;
                    }

                    if (matrix[row][col] == '*') {
                        eatenFood++;
                        matrix[row][col] = '.';
                    }
                    if (matrix[row][col] == 'B') {
                        matrix[row][col] = '.';

                        for (int i = 0; i < matrix.length; i++) {
                            for (int j = 0; j < matrix[i].length; j++) {
                                if (matrix[i][j] == 'B') {
                                    row = i;
                                    col = j;
                                }
                            }
                        }
                    }
                    matrix[row][col] = '.';

                    break;
                case "right":
                    col++;
                    if (isValid(matrix, row, col)) {
                        isValidSnake = false;
                        break;
                    }

                    if (matrix[row][col] == '*') {
                        eatenFood++;
                        matrix[row][col] = '.';
                    }

                    if (matrix[row][col] == 'B') {
                        matrix[row][col] = '.';

                        for (int i = 0; i < matrix.length; i++) {
                            for (int j = 0; j < matrix[i].length; j++) {
                                if (matrix[i][j] == 'B') {
                                    row = i;
                                    col = j;
                                }
                            }
                        }
                    }
                    matrix[row][col] = '.';

                    break;
                case "down":
                    row++;

                    if (isValid(matrix, row, col)) {
                        isValidSnake = false;
                        break;
                    }

                    if (matrix[row][col] == '*') {
                        eatenFood++;
                        matrix[row][col] = '.';
                    }

                    if (matrix[row][col] == 'B') {
                        matrix[row][col] = '.';

                        for (int i = 0; i < matrix.length; i++) {
                            for (int j = 0; j < matrix[i].length; j++) {
                                if (matrix[i][j] == 'B') {
                                    row = i;
                                    col = j;
                                }
                            }
                        }

                    }
                    matrix[row][col] = '.';

                    break;
                case "up":
                    row--;

                    if (isValid(matrix, row, col)) {
                        isValidSnake = false;
                        break;
                    }

                    if (matrix[row][col] == '*') {
                        eatenFood++;
                        matrix[row][col] = '.';
                    }

                    if (matrix[row][col] == 'B') {
                        matrix[row][col] = '.';

                        for (int i = 0; i < matrix.length; i++) {
                            for (int j = 0; j < matrix[i].length; j++) {
                                if (matrix[i][j] == 'B') {
                                    row = i;
                                    col = j;
                                }
                            }
                        }

                    }
                    matrix[row][col] = '.';
                    break;
            }
        }

        if (!isValidSnake && eatenFood < 10) {
            System.out.println("Game over!");
            System.out.println("Food eaten: " + eatenFood);
        } else {
            System.out.println("You won! You fed the snake.");
            System.out.println("Food eaten: 10");
            matrix[row][col] = 'S';
        }
        printMatrix(matrix);
    }


    private static boolean isValid(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length ||
                col < 0 || col >= matrix.length;
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}

import java.util.Scanner;

public class BookWorm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scan.nextLine());
        int number = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[number][number];

        int[] position = new int[2];

        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("P")) {
                position[0] = i;
                position[1] = line.indexOf("P");

            }
        }

        String command = scan.nextLine();

        while (!command.equalsIgnoreCase("end")) {
            switch (command) {
                case "up":
                    movePlayer(position[0] - 1, position[1], position, matrix, text);
                    break;
                case "down":
                    movePlayer(position[0] + 1, position[1], position, matrix, text);

                    break;
                case "right":
                    movePlayer(position[0], position[1] + 1, position, matrix, text);

                    break;
                case "left":
                    movePlayer(position[0], position[1] - 1, position, matrix, text);
                    break;
            }
            command = scan.nextLine();
        }
        printMatrix(matrix, text);
    }

    private static void movePlayer(int newRow, int newCol, int[] position, char[][] matrix, StringBuilder text) {

        if (isOutOfBound(matrix, newRow, newCol)) {
            if (text.length() != 0) {
                text.deleteCharAt(text.length() - 1);
            }
            return;
        }
        if (matrix[newRow][newCol] != '-') {
            text.append(matrix[newRow][newCol]);

        }
        matrix[position[0]][position[1]] = '-';
        matrix[newRow][newCol] = 'P';

        position[0] = newRow;
        position[1] = newCol;
    }

    private static boolean isOutOfBound(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix.length;
    }

    private static void printMatrix(char[][] matrix, StringBuilder text) {
        System.out.println(text);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}


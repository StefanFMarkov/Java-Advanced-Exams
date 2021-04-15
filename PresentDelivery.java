import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PresentDelivery {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfPresents = Integer.parseInt(reader.readLine());
        int size = Integer.parseInt(reader.readLine());

        int startRow = 0;
        int startCol = 0;
        int goodKids = 0;
        int gifted = 0;

        String[][] matrix = new String[size][size];
        for (int i = 0; i < matrix.length; i++) {
            String[] line = reader.readLine().split("\\s+");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = line[j];

                if (matrix[i][j].equals("S")) {
                    startRow = i;
                    startCol = j;
                }
                if (matrix[i][j].equals("V")) {
                    goodKids++;
                }
            }
        }
        matrix[startRow][startCol] = "-";
        String line;
        boolean isOutOfNeighbourhood = false;
        while ((!(line = reader.readLine()).equals("Christmas morning")) && countOfPresents > 0) {
            switch (line) {
                case "up":
                    startRow--;
                    if (startRow < 0) {
                        isOutOfNeighbourhood = true;
                        break;
                    }
                    break;
                case "down":
                    startRow++;
                    if (startRow > matrix.length - 1) {
                        isOutOfNeighbourhood = true;
                        break;
                    }
                    break;
                case "left":
                    startCol--;
                    if (startCol < 0) {
                        isOutOfNeighbourhood = true;
                        break;
                    }
                    break;
                case "right":
                    startCol++;
                    if (startCol > matrix[startRow].length - 1) {
                        isOutOfNeighbourhood = true;
                        break;
                    }
                    break;
            }

            if (isOutOfNeighbourhood) {
                System.out.println("Santa ran out of presents.");
                break;
            }

            if (!matrix[startRow][startCol].equals("-")) {
                switch (matrix[startRow][startCol]) {

                    case "V":
                        countOfPresents--;
                        matrix[startRow][startCol] = "-";
                        gifted++;
                        if (countOfPresents == 0) {
                            System.out.println("Santa ran out of presents!");
                            break;
                        }
                        break;

                    case "X":
                        matrix[startRow][startCol] = "-";
                        break;

                    case "C":
                        boolean isEqualToZero = false;
                        if (!matrix[startRow][startCol - 1].equals("-")) { //left
                            countOfPresents--;
                            if (matrix[startRow][startCol - 1].equals("V")) {
                                gifted++;
                            }
                            matrix[startRow][startCol - 1] = "-";
                            if (countOfPresents == 0) {
                                break;
                            }
                        }

                        if (!matrix[startRow][startCol + 1].equals("-")) { //right
                            countOfPresents--;
                            if (matrix[startRow][startCol + 1].equals("V")) {
                                gifted++;
                            }
                            matrix[startRow][startCol + 1] = "-";
                            if (countOfPresents == 0) {
                                break;
                            }
                        }

                        if (!matrix[startRow - 1][startCol].equals("-")) { // up
                            countOfPresents--;
                            if (matrix[startRow - 1][startCol].equals("V")) {
                                gifted++;
                            }
                            matrix[startRow - 1][startCol] = "-";
                            if (countOfPresents == 0) {
                                break;
                            }
                        }

                        if (!matrix[startRow + 1][startCol].equals("-")) { // down
                            countOfPresents--;
                            if (matrix[startRow + 1][startCol].equals("V")) {
                                gifted++;
                            }
                            matrix[startRow + 1][startCol] = "-";
                            if (countOfPresents == 0) {
                                break;
                            }
                        }
                        break;
                }
            }
            if (countOfPresents == 0) {
                break;
            }
        }

        if (!isOutOfNeighbourhood) {
            matrix[startRow][startCol] = "S";
        }

        for (String[] strings : matrix) {
            for (int col = 0; col < strings.length; col++) {
                System.out.print(strings[col] + " ");
            }
            System.out.println();
        }

        if (goodKids > gifted) {
            System.out.printf("No presents for %d nice kid/s.", goodKids - gifted);
        } else {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", gifted);
        }
    }
}

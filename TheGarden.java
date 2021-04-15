import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class TheGarden {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int row = Integer.parseInt(scan.nextLine());

        Character[][] field = new Character[row][];

        for (int i = 0; i < row; i++) {
            field[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .map(str -> str.charAt(0))
                    .toArray(Character[]::new);
        }

        Map<String, Integer> harvest = new LinkedHashMap<>();

        harvest.put("Carrots:", 0);
        harvest.put("Potatoes:", 0);
        harvest.put("Lettuce:", 0);

        int harmed = 0;

        String input = scan.nextLine();

        while (!input.equals("End of Harvest")) {

            String[] tokens = input.split(" ");
            if (tokens[0].equals("Harvest")) {
                harvestMethod(field, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), harvest);
            } else {

                harmed += mole(field, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), tokens[3]);
            }
            input = scan.nextLine();
        }
        printField(field);

        for (Map.Entry<String, Integer> entry : harvest.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("Harmed vegetables: " + harmed);

    }

    private static int mole(Character[][] field, int row, int col, String direction) {
        if (isOutOfBound(field, row, col)) {
            return 0;
        }
        int harmed = 0;
        String veges = "LPC";
        if (direction.equalsIgnoreCase("Up")) {
            for (int i = row; i >= 0; i -= 2) {
                if (isInBounds(field, i, col)) {
                    if (veges.contains(field[i][col] + "")) {
                        field[i][col] = ' ';
                        harmed++;
                    }
                }
            }
        } else if (direction.equalsIgnoreCase("Down")) {

            for (int i = row; i < field.length; i += 2) {
                if (isInBounds(field, i, col)) {
                    if (veges.contains(field[i][col] + "")) {
                        field[i][col] = ' ';
                        harmed++;
                    }
                }
            }
        } else if (direction.equalsIgnoreCase("Right")) {

            for (int i = col; i < field[row].length; i += 2) {
                if (isInBounds(field, row, i)) {
                    if (veges.contains(field[row][i] + "")) {
                        field[row][i] = ' ';
                        harmed++;
                    }
                }
            }
        } else if (direction.equalsIgnoreCase("Left")) {

            for (int i = col; i >= 0; i -= 2) {
                if (isInBounds(field, row, i)) {
                    if (veges.contains(field[row][i] + "")) {
                        field[row][i] = ' ';
                        harmed++;
                    }
                }
            }
        }
        return harmed;
    }

    private static boolean isInBounds(Character[][] field, int row, int col) {
        return !isOutOfBound(field, row, col);
    }

    private static void printField(Character[][] field) {

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void harvestMethod(Character[][] field, int row, int col, Map<String, Integer> harvest) {
        if (isOutOfBound(field, row, col)) {
            return;
        }
        if (field[row][col] == 'L') {
            field[row][col] = ' ';
            harvest.put("Lettuce:", harvest.get("Lettuce:") + 1);

        } else if (field[row][col] == 'P') {
            field[row][col] = ' ';
            harvest.put("Potatoes:", harvest.get("Potatoes:") + 1);
        } else if (field[row][col] == 'C') {
            field[row][col] = ' ';
            harvest.put("Carrots:", harvest.get("Carrots:") + 1);

        }
    }

    private static boolean isOutOfBound(Character[][] field, int row, int col) {

        return row < 0 || row >= field.length || col < 0 || col >= field[row].length;
    }
}

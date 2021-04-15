import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lootbox {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> firstBox = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondBox = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> collection = new ArrayList<>();

        while (!(firstBox.isEmpty() || secondBox.isEmpty())) {
            int first = firstBox.get(0);
            int second = secondBox.get(secondBox.size() - 1);
            int sum = first + second;
            if (sum % 2 == 0) {
                collection.add(sum);
                firstBox.remove(firstBox.get(0));
                secondBox.remove(secondBox.size() - 1);
            } else {
                firstBox.add(firstBox.size() - 1, second);
                secondBox.remove(secondBox.size() - 1);
            }
        }

        if (firstBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        }

        if (secondBox.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        int sum = 0;
        for (int a : collection) {
            sum += a;
        }

        if (sum >= 100) {
            System.out.println("Your loot was epic! Value: " + sum);
        } else {
            System.out.println("Your loot was poor... Value: " + sum);
        }
    }
}

import java.util.*;
import java.util.stream.Collectors;

public class MakeASalad {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<String> vegetables = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());

        List<Integer> calories = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        List<Integer> makeSalads = new LinkedList<>();

        Map<String, Integer> salads = new HashMap<>();

        salads.put("tomato", 80);
        salads.put("carrot", 136);
        salads.put("lettuce", 109);
        salads.put("potato", 215);

        while (!(vegetables.isEmpty() || calories.isEmpty())) {
            int lastCalories = calories.get(calories.size() - 1);
            int firstVegetable = 0;

            String firstVegetableString = vegetables.get(0);

            if (salads.containsKey(firstVegetableString)) {
                firstVegetable = salads.get(firstVegetableString);
            }
            if (lastCalories - firstVegetable > 0) {
                int diff = lastCalories - firstVegetable;

                vegetables.remove(0);
                if (vegetables.size() >= 1) {
                    firstVegetableString = vegetables.get(0);
                } else {
                    break;
                }
                if (salads.containsKey(firstVegetableString)) {
                    firstVegetable = salads.get(firstVegetableString);
                }
                if (firstVegetable >= diff) {
                    makeSalads.add(lastCalories);
                    calories.remove(calories.size() - 1);
                    vegetables.remove(0);
                }
            } else if (firstVegetable > lastCalories) {
                makeSalads.add(lastCalories);
                calories.remove(calories.size() - 1);
                vegetables.remove(0);
            }
        }
        if (!makeSalads.isEmpty()) {
            for (Integer a : makeSalads) {
                System.out.print(a + " ");
            }
        }

        if (!calories.isEmpty()) {
            System.out.println();
            Collections.reverse(calories);
            for (Integer b : calories) {
                System.out.print(b + " ");
            }
        }
        if (!vegetables.isEmpty()) {
            System.out.println();
            for (String c : vegetables) {
                System.out.print(c + " ");
            }
        }
    }
}

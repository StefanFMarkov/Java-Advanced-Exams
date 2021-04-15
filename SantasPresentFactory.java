import java.util.*;
import java.util.stream.Collectors;

public class SantasPresentFactory {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Integer> materials = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> magicLevel = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        Map<String, Integer> toys = new TreeMap<>();
        while (!(magicLevel.isEmpty() || materials.isEmpty())) {

            int lastMaterial = materials.get(materials.size() - 1);
            int firstMagic = magicLevel.get(0);

            if (lastMaterial == 0) {
                materials.remove(materials.size() - 1);
                continue;
            } else if (firstMagic == 0) {
                magicLevel.remove(magicLevel.size() - 1);
                continue;
            }
            int sum = lastMaterial * firstMagic;

            if (sum == 150) {
                if (!toys.containsKey("Doll")) {
                    toys.put("Doll", 1);
                } else {
                    int count = toys.get("Doll");
                    toys.put("Doll", count + 1);
                }
                materials.remove(materials.size() - 1);
                magicLevel.remove(0);

            } else if (sum == 250) {
                if (!toys.containsKey("Wooden train")) {
                    toys.put("Wooden train", 1);
                } else {
                    int count = toys.get("Wooden train");
                    toys.put("Wooden train", count + 1);
                }
                materials.remove(materials.size() - 1);
                magicLevel.remove(0);

            } else if (sum == 300) {
                if (!toys.containsKey("Teddy bear")) {
                    toys.put("Teddy bear", 1);
                } else {
                    int count = toys.get("Teddy bear");
                    toys.put("Teddy bear", count + 1);
                }
                materials.remove(materials.size() - 1);
                magicLevel.remove(0);

            } else if (sum == 400) {
                if (!toys.containsKey("Bicycle")) {
                    toys.put("Bicycle", 1);
                } else {
                    int count = toys.get("Bicycle");
                    toys.put("Bicycle", count + 1);
                }
                materials.remove(materials.size() - 1);
                magicLevel.remove(0);

            } else if (sum <= 0) {
                int sumNegative = (firstMagic + lastMaterial);
                materials.remove(materials.size() - 1);
                magicLevel.remove(0);
                materials.add(sumNegative);

            } else {
                int add = lastMaterial + 15;

                materials.remove(materials.size() - 1);
                materials.add(materials.size(), add);

                magicLevel.remove(0);
            }
        }

        if (toys.containsKey("Doll") && toys.containsKey("Wooden train")) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else if (toys.containsKey("Teddy bear") && toys.containsKey("Bicycle")) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");

        }

        if (!materials.isEmpty()) {
            Collections.reverse(materials);
            System.out.print("Materials left: ");
            StringBuilder sb = new StringBuilder();
            for (Integer a : materials) {
                sb.append(a).append(", ");
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
            System.out.println(sb.toString());
        }
        if (!magicLevel.isEmpty()) {
            System.out.print("Magic left: ");

            StringBuilder sb = new StringBuilder();
            for (Integer a : magicLevel) {
                sb.append(a).append(", ");
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
            System.out.println(sb.toString());
        }
        if (!toys.isEmpty()) {
            for (Map.Entry<String, Integer> entry : toys.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}

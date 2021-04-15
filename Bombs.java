import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> bombEffect = Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> bombCasting = Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        Map<String, Integer> successfulBombs = new TreeMap<>();

        successfulBombs.put("Datura Bombs", 0);
        successfulBombs.put("Cherry Bombs", 0);
        successfulBombs.put("Smoke Decoy Bombs", 0);


        while (!(bombEffect.isEmpty() || bombCasting.isEmpty())) {
            int daruta = successfulBombs.get("Datura Bombs");
            int cherie = successfulBombs.get("Cherry Bombs");
            int smoke = successfulBombs.get("Smoke Decoy Bombs");
            if (daruta >= 3 && cherie >= 3 && smoke >= 3) {
                break;
            }

            int bombEffectFirst = bombEffect.get(0);
            int bombCastingFirst = bombCasting.get(bombCasting.size() - 1);

            int sum = bombEffectFirst + bombCastingFirst;

            switch (sum) {
                case 40:
                    if (successfulBombs.containsKey("Datura Bombs")) {
                        int value = successfulBombs.get("Datura Bombs");
                        successfulBombs.put("Datura Bombs", value + 1);
                    } else {
                        successfulBombs.put("Datura Bombs", 1);
                    }
                    bombEffect.remove(0);
                    bombCasting.remove(bombCasting.size() - 1);

                    break;
                case 60:
                    if (successfulBombs.containsKey("Cherry Bombs")) {
                        int value = successfulBombs.get("Cherry Bombs");
                        successfulBombs.put("Cherry Bombs", value + 1);
                    } else {
                        successfulBombs.put("Cherry Bombs", 1);
                    }
                    bombEffect.remove(0);
                    bombCasting.remove(bombCasting.size() - 1);

                    break;
                case 120:
                    if (successfulBombs.containsKey("Smoke Decoy Bombs")) {
                        int value = successfulBombs.get("Smoke Decoy Bombs");
                        successfulBombs.put("Smoke Decoy Bombs", value + 1);
                    } else {
                        successfulBombs.put("Smoke Decoy Bombs", 1);
                    }

                    bombEffect.remove(0);
                    bombCasting.remove(bombCasting.size() - 1);

                    break;
                default:
                    bombCasting.remove(bombCasting.size() - 1);
                    bombCasting.add(bombCastingFirst - 5);
            }
        }

        if (successfulBombs.containsKey("Smoke Decoy Bombs") &&
                successfulBombs.containsKey("Cherry Bombs") &&
                successfulBombs.containsKey("Datura Bombs")) {

            int daturaBomb = successfulBombs.get("Datura Bombs");
            int cherieBomb = successfulBombs.get("Cherry Bombs");
            int smokeBomb = successfulBombs.get("Smoke Decoy Bombs");

            if (daturaBomb >= 3 && cherieBomb >= 3 && smokeBomb >= 3) {
                System.out.println("Bene! You have successfully filled the bomb pouch!");
            } else {
                System.out.println("You don't have enough materials to fill the bomb pouch.");
            }
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombEffect.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Bomb Effects: ");
            for (int a : bombEffect) {
                sb.append(a).append(", ");
            }
            sb.deleteCharAt(sb.length() - 2);
            System.out.println(sb);
        }

        if (bombCasting.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Bomb Casings: ");
            for (int a : bombCasting) {
                sb.append(a).append(", ");
            }
            sb.deleteCharAt(sb.length() - 2);
            System.out.println(sb);
        }

        for (Map.Entry<String, Integer> entry : successfulBombs.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}


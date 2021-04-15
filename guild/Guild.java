package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {

    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void addPlayer(Player name) {
        int size = roster.size();
        if (size < capacity) {
            roster.add(name);
        }
    }

    public boolean removePlayer(String player) {
        String name = "";
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).getName().equals(player)) {
                roster.remove(roster.get(i));
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (int i = 0; i < roster.size(); i++) {
            if (name.equals(roster.get(i).getName())) {
                if (roster.get(i).getRank().equals("Member")) {
                    break;
                } else {
                    roster.get(i).setRank("Member");
                    break;
                }
            }
        }
    }

    public void demotePlayer(String name) {
        for (int i = 0; i < roster.size(); i++) {
            if (name.equals(roster.get(i).getName())) {
                roster.get(i).setRank("Trial");
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> remove = new ArrayList<>();

        for (int i = 0; i < roster.size(); i++) {
            if (clazz.equals(roster.get(i).getClazz())) {
                remove.add(roster.get(i));
                roster.get(i).setClazz("-1");
            }
        }

        int check = roster.size();
        for (int j = 0; j < roster.size(); j++) {
            if (roster.get(j).getClazz().equals("-1")) {
                roster.remove(roster.get(j));
                j = j - j;
            }
        }

        Player[] remove1 = new Player[remove.size()];
        for (int i = 0; i < remove.size(); i++) {
            remove1[i] = remove.get(i);
        }
        return remove1;
    }

    public int count() {
        return roster.size();
    }

    public String report() {
        System.out.println();
        StringBuilder result = new StringBuilder();

        result.append(System.lineSeparator());
        System.out.printf("Players in the guild: %s:%n", this.name);
        for (Player player : roster) {
            System.out.println(player.toString());
        }

        return result.toString();
    }

}


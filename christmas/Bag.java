package christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.capacity = capacity;
        this.color = color;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Present> getData() {
        return data;
    }

    public String getColor() {
        return color;
    }

    public int count() {
        return data.size();
    }

    public void add(Present name) {
        if (data.size() < capacity) {
            data.add(name);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)) {
                data.remove(data.get(i));
                return true;
            }
        }
        return false;
    }

    public Present heaviestPresent() {
        int min = Integer.MIN_VALUE;
        Present name = null;

        for (Present now : data) {
            if (now.getWeight() > min) {
                name = now;
            }
        }
        return name;
    }

    public Present getPresent(String name) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)) {
                return data.get(i);
            }
        }
        return null;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s of bag contains:%n", this.color));
        for (Present present : data) {
            sb.append(present.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}

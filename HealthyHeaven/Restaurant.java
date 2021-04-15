package HealthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void add(Salad name) {
        data.add(name);
    }

    public boolean buy(String name) {
        boolean check = false;

        for (int i = 0; i < data.size(); i++) {
            Salad salad = data.get(i);
            if (salad.getName().equals(name)) {
                check = true;
                data.remove(i);
                break;
            }
        }
        return check;

    }

    public String generateMenu() {
        StringBuilder result = new StringBuilder();
        int count = data.size();
        System.out.printf("%s have %d salads:%n", this.name, count);
        for (Salad salad : data) {
            result.append(salad.toString());

        }
        return result.toString();
    }

    public Salad getHealthiestSalad() {

        Salad salad = null;
        int value = Integer.MAX_VALUE;

        for (Salad current : data) {
            if (current.getTotalCalories() < value) {
                salad = current;
            }
        }
        return salad;
    }
}

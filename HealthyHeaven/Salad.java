package HealthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private String name;
    private List<Vegetable> products;
    private int sumCalories;
    private int count;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getTotalCalories() {

        int sum = 0;
        for (Vegetable veges : this.products) {
            sum += veges.getCalories();
        }
        sumCalories = sum;
        return sum;
    }
    public int getProductCount(){
        count = this.products.size();
        return this.products.size();

    }

    public void add(Vegetable product){
        products.add(product);
    }

    @Override
    public String toString( ){
        StringBuilder sb = new StringBuilder();
        int calories = this.getTotalCalories();
        int sizes = this.getProductCount();
       sb.append(String.format("* HealthyHeaven.Salad %s is %d calories and have %d products:%n",this.name,
                calories,
                sizes));
        for (Vegetable vege: this.products) {
           sb.append(vege.toString());
        }
        sb.substring(0,sb.length()-1);
        return sb.toString();
    }
}

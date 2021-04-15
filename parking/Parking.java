package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Parking {

    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return data.removeIf(p -> p.getManufacturer().equals(manufacturer) && p.getModel().equals(model));
    }

    public Car getLatestCar() {
        if (!data.isEmpty()) {
            Stream<Integer> sorted = data.stream().map(Car::getYear)
                    .sorted(Comparator.naturalOrder());
            return data.get(0);
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are parked in %s:", this.type));
        sb.append(System.lineSeparator());
        if (!data.isEmpty()) {
            for (Car car : data) {
                sb.append(car.toString());
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public Car getCar(String manufacturer, String model) {
        if (!data.isEmpty()) {
            for (Car car : data) {
                if (car.getManufacturer().equals(manufacturer) &&
                        car.getModel().equals(model)) {
                    return car;
                }
            }
        }
        return null;
    }


    public List<Car> getParking() {
        return data;
    }

    public void setParking(List<Car> parking) {
        this.data = parking;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

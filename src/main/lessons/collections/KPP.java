package lessons.collections;

import lessons.car.Car;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class KPP {
    private final Queue<Car> cars;
    public KPP() {
        this.cars = new LinkedList<>();
    }
    public  Car addCar(Car nCar) {
        cars.add(nCar);
        if (cars.size() < 4) {
            return null;
        }
       return cars.poll();
    }
}

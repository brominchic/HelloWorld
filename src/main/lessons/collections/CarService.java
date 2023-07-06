package lessons.collections;

import lessons.car.Car;

import java.util.ArrayList;


public class CarService extends ArrayList<ServiceBox> {
    public CarService(int initialCapacity, int stealProbability) {
        super(initialCapacity);

        for (int i = 0; i < initialCapacity; i++) {
            add(i, new ServiceBox<Car>(stealProbability));
        }
    }

    public boolean doService(Car car) {
        for (int i = 0; i < size(); i++) {
            ServiceBox service = get(i);
            if (service.isEmpty()) {
                int stolenFuel = service.getStolenFuel();
                service.doService();
                if (service.getStolenFuel() > stolenFuel) {
                    return true;
                }
                return false;
            }
        }
        throw new RuntimeException("Нет свободных мест");
    }
}

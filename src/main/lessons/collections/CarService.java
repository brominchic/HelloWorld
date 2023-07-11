package lessons.collections;

import lessons.car.DieselCar;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    private final List<ServiceBox<DieselCar>> boxes;

    public CarService() {
        this.boxes = new ArrayList<>();
    }

    public void addServiceBox(ServiceBox<DieselCar> box) {
        this.boxes.add(box);
    }

    public boolean doService(DieselCar car) {
        for (ServiceBox<DieselCar> box : boxes) {
            //тимур, тут сервис раньше даже с машиной не работал!!
            // у меня работал вроде :(
            if (box.isEmpty()) {
                box.parkToService(car);
                int stolenFuel = box.getStolenFuel();
                box.doService();
                return box.getStolenFuel() > stolenFuel;
            }
        }
        throw new RuntimeException("Нет свободных мест");
    }
}

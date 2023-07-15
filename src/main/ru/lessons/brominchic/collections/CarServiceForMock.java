package ru.lessons.brominchic.collections;

import ru.lessons.brominchic.car.DieselCar;

public class CarServiceForMock {
    private ServiceBox box;

    public CarServiceForMock() {
        this.box = new ServiceBox();
    }

    public boolean doService(DieselCar car) {

        if (box.isEmpty()) {
            box.parkToService(car);
            int stolenFuel = box.getStolenFuel();
            box.doService();
            return box.getStolenFuel() > stolenFuel;
        }
        throw new RuntimeException("Нет свободных мест");
    }
}
package lessons.collections;

import lessons.car.Car;

import java.util.Map;

/**
 * Один уровень хранилища машин
 */
public interface CarStorageFloor extends Map<String, Car> {

    /**
     * Возвратит максимальное количество парковочных мест
     */
    int getParkingLotsSize();

    /**
     * Возвратит первое найденное свободное место под машину
     */
    String getAvailableParkingLot();

}

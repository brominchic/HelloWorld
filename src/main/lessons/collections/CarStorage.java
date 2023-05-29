package lessons.collections;

import lessons.car.Car;

import java.util.Collection;

/**
 * Хранилище автомобилей
 */
public interface CarStorage extends Collection<CarStorageFloorImpl> {

    /**
     * Возвращает количество этажей
     */
    int getHeight();

    /**
     * Возвращает количество машин на каждом этаже
     */
    int getAmountPerFloor();

    /**
     * Получить машину из хранилища по номеру парковочного места
     */
    Car getCarFromStorage(String placeNumber);

    /**
     * Запарковать машину на определенное парковочное место
     */
    boolean parkCarToStorage(Car car, String parkingLotNumber);

}

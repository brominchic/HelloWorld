package ru.lessons.brominchic.collections;

import ru.lessons.brominchic.car.Car;

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

    /**
     * Возратит машину по номеру места
     */
    Car getCar(String place);

    /**
     * Паркует машину при наличии данного места
     */
    boolean park(String place, Car car);



}

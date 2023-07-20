package ru.lessons.brominchic.collections;

/**
 * Класс - строитель CarStorage
 */
public interface CarStorageFactory {


    /**
     * Создать хранилище
     *
     * @param height               количество этажей
     * @param amountOfCarsPerFloor количество машин на каждом этаже
     */
    CarStorage createCarStorage(int height, int amountOfCarsPerFloor);
}


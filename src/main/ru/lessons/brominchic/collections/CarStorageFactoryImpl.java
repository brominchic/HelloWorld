package ru.lessons.brominchic.collections;

public class CarStorageFactoryImpl implements CarStorageFactory {
    @Override
    public CarStorage createCarStorage(int height, int amountOfCarsPerFloor) {
        return new CarStorageImpl(amountOfCarsPerFloor, height);
    }
}


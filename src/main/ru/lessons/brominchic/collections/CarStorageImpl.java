package ru.lessons.brominchic.collections;

import ru.lessons.brominchic.car.Car;

import java.util.ArrayList;


public class CarStorageImpl extends ArrayList<CarStorageFloorImpl> implements CarStorage {

    private int amountPerFloor;
    private int height;


    public CarStorageImpl(int amountPerFloor, int height) {
        this.amountPerFloor = amountPerFloor;
        this.height = height ;
        for (int i = 0; i < height; i++) {
            add(i, new CarStorageFloorImpl(amountPerFloor, i));
        }


    }

    @Override
    public int getHeight() {
        return size();
    }


    @Override
    public int getAmountPerFloor() {
        return amountPerFloor;

    }


    @Override
    public Car getCarFromStorage(String placeNumber) {
        var floor = getFloorByNum(placeNumber);
        return floor.getCar(placeNumber);

    }


    @Override
    public void parkCarToStorage(Car car, String parkingLotNumber) {
        getFloorByNum(parkingLotNumber).park(parkingLotNumber, car);

    }

    private CarStorageFloorImpl getFloorByNum(String parkingLotNumber) {
        int NumOfFloor = Integer.parseInt(parkingLotNumber.substring(0, parkingLotNumber.indexOf("-")));
        return get(NumOfFloor);
    }
}




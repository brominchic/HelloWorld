package lessons.collections;

import lessons.car.Car;


import java.util.HashSet;
import java.util.LinkedList;

public class CarStorageImpl extends LinkedList<CarStorageFloorImpl> implements CarStorage {

    int amountPerFloor;
    int height;


    public CarStorageImpl(int amountPerFloor, int height) {
        this.amountPerFloor = amountPerFloor;
        this.height = height - 1;
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
        int num = placeNumber.indexOf("-");
        int sym = Integer.parseInt(placeNumber.substring(0, num));
        var floor = get(sym);
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




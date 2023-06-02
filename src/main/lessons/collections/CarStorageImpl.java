package lessons.collections;

import lessons.car.Car;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class CarStorageImpl extends LinkedList<CarStorageFloorImpl> implements CarStorage {

    int amountPerFloor;
    int height;
    public CarStorageImpl(int amountPerFloor, int height) {
        this.amountPerFloor = amountPerFloor;
        this.height = height-1;
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
            var floorNum= Integer.parseInt(placeNumber);
            var floor = (floorNum-(floorNum % getHeight()))/getHeight();
            return get(floor).getCar(placeNumber);
    }



    @Override
    public boolean parkCarToStorage(Car car, String parkingLotNumber) {
        var floorNum= Integer.parseInt(parkingLotNumber);
        var floor = get((floorNum-(floorNum % getHeight()))/getHeight());
        return floor.park(car,parkingLotNumber);
    }


}

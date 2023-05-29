package lessons.collections;

import lessons.car.Car;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class CarStorageImpl extends LinkedList<CarStorageFloorImpl> implements CarStorage {

    @Override
    public int getHeight() {
        return size();
    }

    ;

    @Override
    public int getAmountPerFloor() {
        return amountPerFloor;
    }

    ;

    @Override
    public Car getCarFromStorage(String placeNumber) {
        for (int i = 0; i < size(); i++){
            var in= Integer.parseInt(placeNumber);
            var a = (in-(in % getHeight()))/getHeight();
            return get(a).getCar(placeNumber);
        }
      return null;
    }

    ;

    @Override
    public boolean parkCarToStorage(Car car, String parkingLotNumber) {
        for (int i = 0; i < size(); i++) {
            if (get(i).park(car, parkingLotNumber))

                return true;
        }
        return false;
    }



    int amountPerFloor;
    int height;

    public CarStorageImpl(int amountPerFloor, int height) {
        this.amountPerFloor = amountPerFloor;
        this.height = height-1;
        for (int i = 0; i < height; i++) {
            add(i, new CarStorageFloorImpl(amountPerFloor, i));
        }
    }
}

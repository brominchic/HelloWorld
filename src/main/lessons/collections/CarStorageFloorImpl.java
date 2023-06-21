package lessons.collections;

import lessons.car.Car;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class CarStorageFloorImpl extends HashMap<String, Car> implements CarStorageFloor {
    public int numberOfFloor;
    public int size;
    private HashSet<String> parkingLots;

    public CarStorageFloorImpl(int size, int numberOfFloor) {
        super(size);
        this.size = size;
        this.numberOfFloor = numberOfFloor;
        this.parkingLots = new HashSet<>();
        for (int i = 0; i < size; i++) {
            String place = numberOfFloor + "-" + i;
            parkingLots.add(place);
        }
    }

    @Override
    public int getParkingLotsSize() {
        return size;
    }

    @Override
    public String getAvailableParkingLot() {
        for (int i = 0; i < size; i++) {
            String numberOfPlace = (numberOfFloor + "-" + i);
            if (parkingLots.contains(numberOfFloor + "-" + i)) {

                return (numberOfFloor + "-" + i);
            }


        }
        return null;
    }


    @Override
    public boolean park(String place, Car car) {

        if (parkingLots.contains(place)) {
            parkingLots.remove(place);
            put(place, car);
            return true;
        }
        throw new RuntimeException("Нет такого места");
    }

    @Override
    public Car getCar(String place) {
        var car = get(place);
        remove(place);
        parkingLots.add(place);
        return car;
    }

}



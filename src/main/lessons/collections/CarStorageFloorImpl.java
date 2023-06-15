package lessons.collections;

import lessons.car.Car;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class CarStorageFloorImpl extends HashMap<String, Car> implements CarStorageFloor {
    public int num;
    public int size;
    public HashSet<String> parkingLots;

    public CarStorageFloorImpl(int size, int num) {
        super(size);
        for (int i = 0; i < size; i++) {
            String place = num + "-" + i;
            put(place, null);
        }
        this.parkingLots= new HashSet<>();
        for (int i = 0; i < size; i++) {
            String place = num + "-" + i;
            parkingLots.add(place);
        }
    }

    @Override
    public int getParkingLotsSize() {
        return size();
    }

    @Override
    public String getAvailableParkingLot() {
        for (int i = 0; i < size(); i++) {
            if (parkingLots.contains(num + "-" + i)) {

                return (num + "-" + i);
            }


        }
        return null;
    }


    public boolean park( String place ,Car car) {

        if (parkingLots.contains(place)) {
            parkingLots.remove(place);
            put(place, car);
            return true;
        }
        return false;
    }

    public Car getCar(String place) {
        var a = get(place);
        parkingLots.add(place);
        return a;
    }

    public HashSet<String> getParkingLots() {
        return parkingLots;
    }
}



package lessons.collections;

import lessons.car.Car;

import java.util.HashMap;

public class CarStorageFloorImpl extends HashMap<String, Car> implements CarStorageFloor {
    public int num;
    public int size;

    public CarStorageFloorImpl(int size, int num) {
        super(size);
        for (int i = 0; i < size; i++) {
            String place = num + "-" + i;
            put(place, null);
        }

    }

    @Override
    public int getParkingLotsSize() {
        return size();
    }

    @Override
    public String getAvailableParkingLot() {
        for (Entry<String, Car> stringCarEntry : this.entrySet()) {
            if (stringCarEntry.getValue() == null) {

                return stringCarEntry.getKey();
            }
        }
        return null;
    }

    boolean park(Car car, String place) {

        if (this.containsKey(place)) {
            if (get(place) == null) {
                put(place, car);
                return true;
            }

        }

        return false;
    }

    public Car getCar(String place) {
        var a = get(place);
        put(place, null);
        return a;
    }


}



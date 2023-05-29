package lessons.collections;

import lessons.car.Car;

import java.util.HashMap;

public class CarStorageFloorImpl extends HashMap<String, Car> implements CarStorageFloor {

    @Override
    public int getParkingLotsSize() {
        return size();
    }

    @Override
    public String getAvailableParkingLot() {
        for (Entry<String, Car> stringCarEntry : this.entrySet()) {
            if (stringCarEntry.getValue() == null){

                return stringCarEntry.getKey();
            }
        }
        return null;
    }
    boolean park(Car car, String place){

            if (this.containsKey(place)){
                if (get(place)== null){
                  put(place,car);
                  return true;
                }

            }

        return false;
    }
    public Car getCar(String place){
        var a =get(place);
                put(place,null);
                return a;
    }
   public int num;
    public int size;
    public CarStorageFloorImpl(int size,int num) {
        super(size);
        for (int i = (size*num); i <(size*(num+1)); i++) {

            put(String.valueOf(i),null);
        }

    }

}



package lessons.collections;

import lessons.car.Car;
import lessons.car.DieselCar;
import lessons.car.Fuel;
import lessons.car.GasCar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class ServiceBox<E extends Car> extends HashMap<String, E> {
    private int size;
    private HashSet<String> parkingLots;
    private HashMap<Car, String> checkingLots;
    private int stolenFuel;

    public ServiceBox(int size) {
        super(size);
        this.size = size;
        this.parkingLots = new HashSet<String>();
        this.checkingLots = new HashMap<Car, String>();
        for (int i = 0; i < size; i++) {
            parkingLots.add(Integer.toString(i));
        }
    }

    public String getAvailableParkingLot() {
        for (int i = 0; i < size; i++) {
            String numberOfPlace = Integer.toString(i);
            if (parkingLots.contains(numberOfPlace)) {

                return (numberOfPlace);
            }


        }
        return null;
    }

    public boolean parkToService(String place, E car) {

        if (parkingLots.contains(place)) {
            parkingLots.remove(place);
            put(place, car);
            checkingLots.put(car, "Unchecked");
            return true;
        }
        throw new RuntimeException("Нет такого места");
    }


    public Car getCar(String place) {
        E car = get(place);
        remove(place);
        checkingLots.remove(car);
        parkingLots.add(place);
        return car;
    }

    public void doService(String place) {
        E car = get(place);
        if (checkingLots.get(car).equals("Unchecked")) {
            checkingLots.remove(car);
            checkingLots.put(car, "Checked");
            if (car.getClass().equals(GasCar.class)) {
                Random rnd = new Random();
                int amount = rnd.nextInt(3,4);
                car.reduceFuel(amount, Fuel.Gas);
                stolenFuel = stolenFuel + amount;
            }
            if (car.getClass().equals(DieselCar.class)) {
                Random rnd = new Random();
                int amount = rnd.nextInt(1, 2);
                car.reduceFuel(amount, Fuel.Diesel);
                stolenFuel = stolenFuel + amount;
            }
        }
    }

    public int getStolenFuel() {
        return stolenFuel;
    }
}
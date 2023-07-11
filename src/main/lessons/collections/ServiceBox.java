package lessons.collections;

import lessons.car.Car;

import java.util.concurrent.ThreadLocalRandom;

public class ServiceBox<E extends Car> {
    private int stealProbability;
    private E car;
    private int stolenFuel;

    public ServiceBox(int stealProbability) {
        this.stealProbability = stealProbability;
        this.car = null;
    }

    public ServiceBox() {
    }

    public void parkToService(E car) {
        if (this.car == (null)) {
            this.car = car;
        } else throw new RuntimeException("ЗАНЯТО");
    }

    public Car getCar() {
        E returnedCar = car;
        this.car = null;
        return returnedCar;
    }

    public void doService() {
        if (this.car != null) {
            steal(1);
        } else throw new RuntimeException("Нет машины");
    }

    public int getStolenFuel() {
        return stolenFuel;
    }

    private void steal(int amount) {
        if (ThreadLocalRandom.current().nextInt(0, 100) < stealProbability) {
            car.reduceFuel(amount);
            stolenFuel += amount;
        }
    }

    boolean isEmpty() {
        if (this.car == null) {
            return true;
        }
        return false;
    }
}
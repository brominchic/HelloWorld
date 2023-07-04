package lessons.collections;

import lessons.car.Car;
import lessons.car.DieselCar;
import lessons.car.Fuel;
import lessons.car.GasCar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class ServiceBox<E extends Car> {
    private int stealProbability;
    private E car;
    private Random random;
    private int stolenFuel;

    public ServiceBox(int stealProbability) {
        this.stealProbability = stealProbability;
        this.car = null;
        this.random = new Random();
    }


    public void parkToService(E car) {
        if (this.car==(null)) {
            this.car = car;
        }
        else throw new RuntimeException("ЗАНЯТО");
    }

    public Car getCar() {
        E returnedCar = car;
        this.car = null;
        return returnedCar;

    }

    public void doService() {
      if(steal()){
          car.reduceFuel(1);
          stolenFuel=stolenFuel+1;
      }
    }

    public int getStolenFuel() {
        return stolenFuel;
    }
    private boolean steal(){
        return random.nextInt(0, 100) < stealProbability;
    }
}
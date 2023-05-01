package ru.java.lessons.car;

import ru.java.lessons.fuel.Diesel;
import ru.java.lessons.fuel.Fuel;
import ru.java.lessons.fuel.Gas;

public class DieselCar extends Car {
    public DieselCar(Tank gasTank) {
        super(gasTank);
    }

    @Override
    public void ride() {

    }

    @Override
    public void recharge(int value, Fuel fuel) {
        if(fuel instanceof Diesel){
            tank.addFuel(value);
        }
        else{
            throw new RuntimeException("Неправильный тип топлива");
        }

    }
}

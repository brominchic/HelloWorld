package ru.java.lessons.car;

import ru.java.lessons.fuel.Fuel;

public class Car {
    private Fuel fuel;
    public void ride(){}
    public void recharge(){}

    public Car(Fuel fuel) {
        this.fuel = fuel;
    }
}

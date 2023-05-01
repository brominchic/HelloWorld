package ru.java.lessons.car;

import ru.java.lessons.fuel.Diesel;
import ru.java.lessons.fuel.Fuel;

public abstract class Car {
    protected Tank tank;

    public abstract void ride();
    public abstract void recharge(int value,Fuel fuel);

    public Car(Tank tank) {
        this.tank = tank;
    }
}

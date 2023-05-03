package ru.java.lessons.car;



public abstract class Car {
    protected Tank tank;

    public abstract void ride();

    public Car(Tank tank) {
        this.tank = tank;
    }


    public abstract void recharge(int value, Fuel fuel);
}

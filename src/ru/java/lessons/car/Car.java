package ru.java.lessons.car;



public abstract class Car {
    protected Tank tank;

    public abstract void ride();
    public abstract void recharge(int value,String fuel);

    public Car(Tank tank) {
        this.tank = tank;
    }


}

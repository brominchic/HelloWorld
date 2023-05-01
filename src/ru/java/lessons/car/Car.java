package ru.java.lessons.car;

public class Car {
    private Tank tank;

    public void ride(){}
    public void recharge(int value){
        System.out.println(tank.getAmount());
        tank.addFuel(value);
    }

    public Car(Tank tank) {
        this.tank = tank;
    }
}

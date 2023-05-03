package ru.java.lessons.car;



public class DieselCar extends Car {
    public DieselCar(Tank gasTank) {
        super(gasTank);
    }

    @Override
    public void ride() {

    }

    @Override
    public void recharge(int value, Fuel fuel) {
        if(fuel == Fuel.Diesel){
            tank.addFuel(value);
        }
        else{
            throw new RuntimeException("Неправильный тип топлива");
        }

    }
}

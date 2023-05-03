package ru.java.lessons.car;



public class GasCar extends Car {
    public GasCar(Tank gasTank) {
        super(gasTank);
    }

    @Override
    public void ride() {
    }

    @Override
    public void recharge(int value, String fuel) {
        if(fuel == Fuel.Gas.getTitle()){
            tank.addFuel(value);
        }
        else{
            throw new RuntimeException("Неправильный тип топлива");
        }
    }
}

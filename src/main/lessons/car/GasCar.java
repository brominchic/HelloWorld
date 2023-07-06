package lessons.car;


public class GasCar extends Car {
    public GasCar(Tank gasTank) {
        super(gasTank);
    }

    @Override
    public void recharge(int value, Fuel fuel) {
        if (fuel == Fuel.Gas) {
            tank.addFuel(value);
        } else {
            throw new RuntimeException("Неправильный тип топлива");
        }
    }

}
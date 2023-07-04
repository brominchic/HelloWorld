package lessons.car;


public class DieselCar extends Car {
    public DieselCar(Tank gasTank) {
        super(gasTank);
    }


    @Override
    public void recharge(int value, Fuel fuel) {
        if (Fuel.Diesel.equals(fuel)) {
            tank.addFuel(value);
        } else {
            throw new RuntimeException("Неправильный тип топлива");
        }

    }

    @Override
    public void reduceFuel(int value) {

        tank.reduce(value);

    }
    @Override
    public int getAmountOfFuel () {
        return tank.getAmount();
    }
}

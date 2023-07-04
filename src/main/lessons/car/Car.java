package lessons.car;


public abstract class Car {
    protected Tank tank;

    public Car(Tank tank) {
        this.tank = tank;
    }

    public abstract void recharge(int value, Fuel fuel);

    public abstract void reduceFuel(int value);
    public abstract int getAmountOfFuel();
}

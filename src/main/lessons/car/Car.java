package lessons.car;


public abstract class Car<T> {
    protected Tank tank;

    public Car(Tank tank) {
        this.tank = tank;
    }

    public abstract void recharge(int value, Fuel fuel);

    public void reduceFuel(int value) {
        tank.reduce(value);
    }
    
    public int getAmountOfFuel() {
        return tank.getAmount();
    }

}

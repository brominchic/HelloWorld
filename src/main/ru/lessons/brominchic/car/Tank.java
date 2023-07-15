package ru.lessons.brominchic.car;


public class Tank {

    private int amount;
    private int maxAmount;

    public Tank(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public int getAmount() {
        return this.amount;
    }

    public void addFuel(int amount) {
        int futureAmount = amount + this.amount;
        if (futureAmount > maxAmount) {
            throw new RuntimeException();
        }
        this.amount = futureAmount;
    }

    public void reduce(int amount) {
        int futureAmount = amount - this.amount;
        if (futureAmount < 0) {
            throw new RuntimeException();
        }
        this.amount = futureAmount;
    }
}

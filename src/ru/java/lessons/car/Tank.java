package ru.java.lessons.car;

import ru.java.lessons.fuel.Fuel;

public class Tank {

    private int amount;
    private int maxAmount;
    public int getAmount(){
    return this.amount;
    }

    public Tank(int maxAmount) {
        this.maxAmount=maxAmount;
    }

    public void addFuel(int amount){
        int futureAmount=amount+this.amount;
        if (futureAmount > maxAmount){
            throw new RuntimeException();
        }
        this.amount=futureAmount;
    }
}

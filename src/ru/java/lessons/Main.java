package ru.java.lessons;

import ru.java.lessons.car.DieselCar;
import ru.java.lessons.car.Tank;
import ru.java.lessons.fuel.Diesel;
import ru.java.lessons.fuel.Fuel;
import ru.java.lessons.fuel.Gas;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        var car = new DieselCar(new Tank(100));
        System.out.println("1");

        car.recharge(10,new Gas());
    }
}
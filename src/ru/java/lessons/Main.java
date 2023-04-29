package ru.java.lessons;

import ru.java.lessons.car.DieselCar;
import ru.java.lessons.fuel.Diesel;
import ru.java.lessons.fuel.Fuel;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        var car = new DieselCar(new Diesel());
        System.out.println("1");

    }
}
package lessons;

import lessons.car.Fuel;
import lessons.car.Tank;
import lessons.car.DieselCar;
import lessons.collections.KPP;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        var car = new DieselCar(new Tank(100));

        System.out.println("1");

        car.recharge(100, Fuel.Diesel);
    }
}
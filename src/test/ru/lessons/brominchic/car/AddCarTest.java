package ru.lessons.brominchic.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.lessons.brominchic.collections.KPP;

public class AddCarTest {
    @Test
    void test() {
        var firstCar = new DieselCar(new Tank(100));
        var secondCar = new DieselCar(new Tank(100));
        var thirdCar = new DieselCar(new Tank(100));
        var fourthCar = new DieselCar(new Tank(100));
        var fifthCar = new DieselCar(new Tank(100));
        var sixthCar = new DieselCar(new Tank(100));
        var testKPP = new KPP();
        testKPP.addCar(firstCar);
        testKPP.addCar(secondCar);
        testKPP.addCar(thirdCar);
        var firstTest = testKPP.addCar(fourthCar);
        Assertions.assertEquals(firstCar, firstTest);

        testKPP.addCar(fifthCar);
        var secondTest = testKPP.addCar(sixthCar);
        Assertions.assertEquals(thirdCar, secondTest, "неверно");

    }
}

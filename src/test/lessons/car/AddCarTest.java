package lessons.car;
import lessons.car.DieselCar;
import lessons.car.Tank;
import lessons.collections.KPP;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(firstCar,firstTest);

        testKPP.addCar(fifthCar);
        var secondTest = testKPP.addCar(sixthCar);
        assertEquals(thirdCar,secondTest,"неверно");

}
}

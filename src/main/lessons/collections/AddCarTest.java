package lessons.collections;
import lessons.car.DieselCar;
import lessons.car.Tank;
import org.junit.jupiter.api.Test;

public class AddCarTest {
    @Test
    void test() {
        var firstcar = new DieselCar(new Tank(100));
        var secondcar = new DieselCar(new Tank(100));
        var thirdcar = new DieselCar(new Tank(100));
        var fourthcar = new DieselCar(new Tank(100));
        var fifthcar = new DieselCar(new Tank(100));
        var sixthcar = new DieselCar(new Tank(100));
        var seventhcar = new DieselCar(new Tank(100));
        var TestKPP = new KPP();
        TestKPP.addCar(firstcar);
        TestKPP.addCar(secondcar);
        TestKPP.addCar(thirdcar);
        var firstTest = TestKPP.addCar(fourthcar);
        if (firstTest.equals(firstcar)) {
            System.out.println("itworks");

        } else {
            throw new RuntimeException("Не та машина");
        }

        TestKPP.addCar(fifthcar);
        var secondTest = TestKPP.addCar(sixthcar);
        if (secondTest.equals(thirdcar)) {
            System.out.println("itworks");

        } else {
            throw new RuntimeException("Не та машина");
    }
}
}

package lessons.car.collections;

import lessons.car.Car;
import lessons.car.DieselCar;
import lessons.car.GasCar;
import lessons.car.Tank;
import lessons.collections.ServiceBox;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServiceBoxTest {


    @Test
    void testServiceBox() {
        var serviceBoxForGasCar = new ServiceBox<>(10);
        var serviceBoxForDieselCar = new ServiceBox<>(10);
        for (int i = 0; i < 10; i++) {
            GasCar gasCar = new GasCar(new Tank(100));
            serviceBoxForGasCar.parkToService(Integer.toString(i), gasCar);
            serviceBoxForGasCar.doService(Integer.toString(i));
            assertEquals(gasCar, serviceBoxForGasCar.getCar(Integer.toString(i)));
        }
        for (int i = 0; i < 10; i++) {
            DieselCar dieselCar = new DieselCar(new Tank(100));
            serviceBoxForDieselCar.parkToService(Integer.toString(i), dieselCar);
            serviceBoxForDieselCar.doService(Integer.toString(i));
            assertEquals(dieselCar, serviceBoxForDieselCar.getCar(Integer.toString(i)));
        }
        assertTrue(serviceBoxForGasCar.getStolenFuel() > serviceBoxForDieselCar.getStolenFuel());
    }
}

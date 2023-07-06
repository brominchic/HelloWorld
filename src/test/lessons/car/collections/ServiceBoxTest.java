package lessons.car.collections;

import lessons.car.*;
import lessons.collections.ServiceBox;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServiceBoxTest {
    public int stolenGas;
    public int stolenDiesel;

    @Test
    void testServiceBox() {
        var serviceBoxForGasCar = new ServiceBox<Car>(50);
        var serviceBoxForDieselCar = new ServiceBox<DieselCar>(10);
        for (int i = 0; i < 10; i++) {
            GasCar gasCar = new GasCar(new Tank(100));
            gasCar.recharge(1, Fuel.Gas);
            serviceBoxForGasCar.parkToService(gasCar);
            serviceBoxForGasCar.doService();
            assertEquals(gasCar, serviceBoxForGasCar.getCar());
            stolenGas = stolenGas + 1 - gasCar.getAmountOfFuel();
        }
        try {
            serviceBoxForGasCar.doService();
        } catch (RuntimeException thrown) {
            assertEquals("Нет машины", thrown.getMessage());
        }
        for (int i = 0; i < 10; i++) {
            DieselCar dieselCar = new DieselCar(new Tank(100));
            dieselCar.recharge(1, Fuel.Diesel);
            serviceBoxForDieselCar.parkToService(dieselCar);
            serviceBoxForDieselCar.doService();
            assertEquals(dieselCar, serviceBoxForDieselCar.getCar());
            stolenDiesel = stolenDiesel + 1 - dieselCar.getAmountOfFuel();
        }
        assertTrue(serviceBoxForGasCar.getStolenFuel() > serviceBoxForDieselCar.getStolenFuel());
        assertEquals(serviceBoxForGasCar.getStolenFuel(), stolenGas);
        assertEquals(serviceBoxForDieselCar.getStolenFuel(), stolenDiesel);
    }
}

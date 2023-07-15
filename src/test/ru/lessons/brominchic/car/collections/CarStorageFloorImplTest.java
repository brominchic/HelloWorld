package ru.lessons.brominchic.car.collections;

import org.junit.jupiter.api.Test;
import ru.lessons.brominchic.car.Car;
import ru.lessons.brominchic.car.DieselCar;
import ru.lessons.brominchic.car.Tank;
import ru.lessons.brominchic.collections.CarStorageFloorImpl;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CarStorageFloorImplTest {
    @Test
    void carStorageFloorImplTest() {
        CarStorageFloorImpl floor = new CarStorageFloorImpl(10, 0);
        assertEquals(10, floor.getParkingLotsSize());
        for (Map.Entry<String, Car> stringCarEntry : floor.entrySet()) {
            assertNull(stringCarEntry.getValue());

        }
        for (int i = 0; i < 10; i++) {
            floor.park(floor.getAvailableParkingLot(), new DieselCar(new Tank(100)));

        }
        for (Map.Entry<String, Car> stringCarEntry : floor.entrySet()) {
            assertNotNull(stringCarEntry.getValue());

        }
        assertNull(floor.getAvailableParkingLot());
    }

    @Test
    void carStorageFloorParkTest() {
        CarStorageFloorImpl floor = new CarStorageFloorImpl(10, 0);
        try {
            floor.park("0-10", new DieselCar(new Tank(100)));

        } catch (RuntimeException thrown) {
            assertEquals("Нет такого места", thrown.getMessage());
        }
    }
}

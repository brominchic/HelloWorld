package lessons.car.collections;

import lessons.car.Car;
import lessons.car.DieselCar;
import lessons.car.Tank;
import lessons.collections.CarStorage;
import lessons.collections.CarStorageFactory;
import lessons.collections.CarStorageFloor;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CarStorageTest {

    private CarStorage carStorage;
    private CarStorageFactory carStorageFactory;

//    раскомментируй и создай carStorage
//public CarStorageTest() {
//    this.carStorage
//    this.carStorageFactory
//}

    @Test
    void testCarStorageImpl() {
        var storage = carStorageFactory.createCarStorage(10, 10);

        Map<String, Car> resultChecker = new HashMap<>();

        assertEquals(10, storage.getAmountPerFloor());
        assertEquals(10, storage.getHeight());
        for (CarStorageFloor carStorageFloor : storage) {
            assertEquals(10, carStorageFloor.getParkingLotsSize());
            for (int i = 0; i < 10; i++) {
                var car = new DieselCar(new Tank(100));
                var parkingLot = carStorageFloor.getAvailableParkingLot();
                assertNotNull(parkingLot);
                // паркуем машину
                carStorage.parkCarToStorage(car, parkingLot);
                //запоминаем что запарковали машину сюда
                resultChecker.put(parkingLot, car);
            }
            assertNull(carStorageFloor.getAvailableParkingLot());
        }

        // получаем машины с парковки, проверяем что каждая машина припаркована именно на то место где мы ее оставили
        for (Map.Entry<String, Car> parkedCar : resultChecker.entrySet()) {
            String parkingLotNumber = parkedCar.getKey();
            var unParkedCar = carStorage.getCarFromStorage(parkingLotNumber);
            assertEquals(resultChecker.get(parkingLotNumber), unParkedCar);
        }

        // проверяем что все места свободны и количество парковочных мест не изменилось
        for (CarStorageFloor carStorageFloor : carStorage) {
            assertEquals(10, carStorageFloor.size());
            for (Car value : carStorageFloor.values()) {
                assertNull(value);
            }
        }

    }
}

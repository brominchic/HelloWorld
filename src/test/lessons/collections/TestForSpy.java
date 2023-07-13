package lessons.collections;

import lessons.car.DieselCar;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestForSpy {
    @Spy
    ServiceBox<DieselCar> serviceBox = new ServiceBox<>(50);

    @Test
    void SpyTest() {
        when(serviceBox.isEmpty()).thenReturn(Boolean.FALSE);
        CarService carService = new CarService();
        carService.addServiceBox(serviceBox);
        try {
            carService.doService(mock(DieselCar.class));
        } catch (RuntimeException thrown) {
            assertEquals("Нет свободных мест", thrown.getMessage());
        }
    }
}

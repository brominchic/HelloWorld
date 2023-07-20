package ru.lessons.brominchic.collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.lessons.brominchic.car.DieselCar;
import ru.lessons.brominchic.car.Tank;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TestForCaptor {
    @Captor
    ArgumentCaptor<DieselCar> carCaptor;

    @Test
    void testCarServiceCapture() {
        DieselCar dieselCar = new DieselCar(new Tank(100));
        ServiceBox<DieselCar> serviceBox = Mockito.mock(ServiceBox.class);
        serviceBox.parkToService(dieselCar);
        verify(serviceBox).parkToService(carCaptor.capture());
        assertTrue(dieselCar.equals(carCaptor.getValue()));
    }
}

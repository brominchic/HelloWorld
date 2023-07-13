package lessons.collections;

import lessons.car.DieselCar;
import lessons.car.Tank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestForCaptor {
    @Captor
    ArgumentCaptor<DieselCar> carCaptor;

    @Test
    void testCarServiceCapture() {
        DieselCar dieselCar = new DieselCar(new Tank(100));
        ServiceBox<DieselCar> serviceBox = mock(ServiceBox.class);
        serviceBox.parkToService(dieselCar);
        verify(serviceBox).parkToService(carCaptor.capture());
        assertTrue(dieselCar.equals(carCaptor.getValue()));
    }
}

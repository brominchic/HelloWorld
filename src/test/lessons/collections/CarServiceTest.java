package lessons.collections;

import lessons.car.Car;
import lessons.car.DieselCar;
import lessons.car.GasCar;
import lessons.car.Tank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    private CarService carService;

    @BeforeEach
    void setUp() {
        this.carService = new CarService();
    }

    @Test
    void testCarServiceMock() {

        ServiceBox<DieselCar> sb = mock(ServiceBox.class);

        carService.addServiceBox(sb);
        when(sb.isEmpty()).thenReturn(Boolean.TRUE);
        when(sb.getStolenFuel()).thenAnswer(new Answer() {
            private int count = 0;

            public Object answer(InvocationOnMock invocation) {
                return count++;
            }
        });

        assertTrue(carService.doService(mock(DieselCar.class)));
    }

    @Test
    void testCarServiceSpy() {
        ServiceBox<DieselCar> serviceBox = spy(ServiceBox.class);
        Mockito.doReturn(Boolean.TRUE).when(serviceBox).isEmpty();
        when(serviceBox.getStolenFuel()).thenAnswer(new Answer() {
            private int count = 0;

            public Object answer(InvocationOnMock invocation) {
                return count++;
            }
        });
        carService.addServiceBox(serviceBox);
        assertTrue(carService.doService(mock(DieselCar.class)));
    }

    @Captor
    ArgumentCaptor<DieselCar> carCaptor;

    @Test
    void testCarServiceCapture() {
        DieselCar dieselCar = new DieselCar(new Tank(100));
        ServiceBox<DieselCar> serviceBox = spy(ServiceBox.class);
        serviceBox.parkToService(dieselCar);
        verify(serviceBox).parkToService(carCaptor.capture());
        assertTrue(dieselCar.equals(carCaptor.getValue()));
    }

    @Mock
    ServiceBox<DieselCar> service;
    @InjectMocks
    CarServiceForMock carServiceForMock = new CarServiceForMock();

    @Test
    void testCarServiceInject() {
        when(service.isEmpty()).thenReturn(Boolean.TRUE);
        when(service.getStolenFuel()).thenAnswer(new Answer() {
            private int count = 0;

            public Object answer(InvocationOnMock invocation) {
                return count++;
            }
        });
        assertTrue(carServiceForMock.doService(mock(DieselCar.class)));
    }
}
package ru.lessons.brominchic.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import ru.lessons.brominchic.car.DieselCar;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

}
package ru.lessons.brominchic.collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.lessons.brominchic.car.DieselCar;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestForInject {
    @Mock
    ServiceBox<DieselCar> service;
    @InjectMocks
    CarServiceForMock carServiceForMock = new CarServiceForMock();

    @Test
    void testCarServiceInject() {
        when(service.isEmpty()).thenReturn(Boolean.TRUE);
        when(service.getStolenFuel()).thenReturn(0);
        assertFalse(carServiceForMock.doService(mock(DieselCar.class)));
    }
}

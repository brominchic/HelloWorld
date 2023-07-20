package ru.lessons.brominchic.car;

import org.junit.jupiter.api.Test;

class DieselCarTest {


    @Test
    void name() {
        var dcar = new DieselCar(new Tank(100));
        dcar.recharge(10, Fuel.Diesel);
    }
}
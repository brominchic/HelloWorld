package lessons.car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DieselCarTest {


    @Test
    void name() {
       var dcar=  new DieselCar(new Tank(100));
       dcar.recharge(10,null);
    }
}
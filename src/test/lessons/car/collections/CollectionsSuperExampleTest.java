package lessons.car.collections;

import lessons.car.Car;
import lessons.car.DieselCar;
import lessons.car.GasCar;
import lessons.car.Tank;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionsSuperExampleTest {

    @Test
    void extendsWildcard() {
//        List<? extends Car> listOfCars = new ArrayList<>(); // так писать не требуется так как наследники по умолчанию приводятся к тому же типу
        List<Car> listOfCars = new ArrayList<>();

        // считай тут можно пихать все что extends Car
        listOfCars.add(new DieselCar(null));

        assertEquals(1, listOfCars.size());

        // listOfCars.add(new Object()); а вот такой естественно не примет
    }

    @Test
    void superWildcard() {
        List<ExampleCar> listOfExampleCars = new ArrayList<>();
        List<DieselCar> listOfDieselCars = new ArrayList<>();
        List<Car> listOfCars = new ArrayList<>();
        List<Object> listOfObjects = new ArrayList<>();

//        showExample(listOfExampleCars); нельзя, exampleCar не super для Diesel
        showExample(listOfDieselCars);
        showExample(listOfCars);    // можно так как super
        showExample(listOfObjects);    // можно так как super

    }

    // принимает все что super DieselCar включительно
    // такой код это редкий случай но лучше понимать что он делает
    private void showExample(List<? super DieselCar> list) {
    }

    private static class ExampleCar extends DieselCar {

        public ExampleCar(Tank gasTank) {
            super(gasTank);
        }
    }
}

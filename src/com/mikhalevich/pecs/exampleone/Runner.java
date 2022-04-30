package com.mikhalevich.pecs.exampleone;

import java.lang.management.ManagementFactory;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {


    public static void main(String[] args) {
        MyObjectStore<Long, Car> carsStore = new MyObjectStoreImpl<Long, Car>();

        Car car1 = new Car("BMW", "X5");
        Car car2 = new Car("MERCEDES", "C500");

        carsStore.put(2222L, car1);
        carsStore.put(2223L, car2);


        Predicate<Car> predicate0 = new Predicate<Car>() {
            @Override public boolean apply(Car exp) {
                return true;
            }
        };

        Predicate<Vehicle> predicate1 = new Predicate<Vehicle>() {
            @Override public boolean apply(Vehicle exp) {
                return true;
            }
        };


        Collection<Car> cars = carsStore.getAll(predicate1);

        carsStore.putAll(Map.of(1L, new Car("1", "2")));


        System.out.println(cars);
    }
}





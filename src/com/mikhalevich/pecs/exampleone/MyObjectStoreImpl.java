package com.mikhalevich.pecs.exampleone;

import java.util.*;

public class MyObjectStoreImpl<Long, Car> implements MyObjectStore<Long, Car>{

    private Map<Long,Car> carMap = new HashMap<Long, Car>();

    @Override
    public void put(Long key, Car value) {
        carMap.put(key, value);
    }

    @Override
    public Car get(Long key) {
        return carMap.get(key);
    }


    // Predicate<? super Car> p - потребитель
    @Override
    public Collection<Car> getAll(Predicate<? super Car> p) {
        List listCar = new ArrayList();
        for( Map.Entry<Long, Car> entry : carMap.entrySet()){
            listCar.add(entry);
        }
        return listCar;
    }

    @Override
    public void putAll(Map entries) {
        carMap.putAll(entries);
    }

    @Override
    public Map getAll(Collection keys) {
        return carMap;
    }

}

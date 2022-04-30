package com.mikhalevich.pecs.exampletwo;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        /**
         *  Иерархия классов
         *  Object
         *  Entity
         *  Animal
         *  Pet
         *  Dog, Kitty
         */

        List<Object> objects = new ArrayList<>();
        objects.add(new NotExtends());

        List<Entity> entities = new ArrayList<>();
        entities.add(new Entity());

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal());

        List<Pet> pet = new ArrayList<>();
        pet.add(new Pet("P"));

        List<Dog> dog = new ArrayList<>();
        dog.add(new Dog("G"));

        // Тест 0. Хоть Dog и наследник Animals в параметр List<Animal> animals метода test0 он не влазит
        // test0(dog);

        // Тест 1. Объеденённый общим обобщением <T> метод copy не примет в первый параметр (super)
        // список, который ниже по иерархии чем второй параметр extends
        test1(entities, animals);

        Animal animal2 = new Dog("D");

        // Тест 2. Невозможно положить ничего ВЫШЕ по иерархии чем Pet
        // Парадокс
        // Но при этом и достать в методе test2 невозможно ничего,
        // что по иерархии НИЖЕ чем Pet (Если не Кастить)
        test2(pet);

        // Невозможно хранить родительский тип в дочернем
//        Dog dog1 = animals.get(0);

        // Невозможно хранить родительский тип в дочернем
//        dog.add(new Animal());

        // Тест 3.
        test3(entities);

        for(Pet p: pet) p.call();


    }


    public static void test0 (List<Animal> animals){
    }

    public static <T> void test1(List<? super T> dest, List<? extends T> src) {
        dest.add(src.get(1));
    }

    public static void test2(List<? extends Pet> src) {

        // Неизвестно, объекты какого именно класса будут содержаться в листе src.
        // Коллекция является продюсером элементов

        Entity entity = src.get(0);
        Animal animal = src.get(0);
        Pet pet = src.get(0);
//        Dog dog0 = src.get(0);

        Dog dog1 = (Dog) src.get(0);
    }

    public static void test3(List<? super Pet> dest) {

        // Коллекция является Консюмером элементов

//        dest.add(new Entity());
//        dest.add(new Animal());
        dest.add(new Pet("P"));
        dest.add(new Dog("P"));

        dest.get(0);

        dest.add((Pet) new Entity());

    }


}

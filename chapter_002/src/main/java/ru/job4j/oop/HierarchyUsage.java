package ru.job4j.oop;

public class HierarchyUsage {
    public static void main(String[] args) {
        // создаем объект класса Car
        Car car = new Car();
        // делаем приведение к типу родителя
        Transport tp = car;
        // делаем приведение к типу родителя Object
        Object obj = car;
        // Приведение типа при создании объекта
        Object ocar = new Car();
        // Приведение типа за счет  понижения в иерархии
        Car carFromObject = (Car) ocar;

        // Ошибка в приведении типа.
        Object bicycle = new Bicycle();
        Car cb = (Car) bicycle; // код завершится с ошибкой приведения типов ClassCastExeption
    }
}

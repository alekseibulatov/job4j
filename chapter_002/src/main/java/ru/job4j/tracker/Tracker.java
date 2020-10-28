package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    //private final Item[] items = new Item[100];
    private final ArrayList<Item> items = new ArrayList<Item>();


    /**
     * Метод добавления заявки в хранилище
     *
     * @param item новая заявка
     */
    public ArrayList<Item> add(Item item) {
        item.setId(generateId());
        items.add(item);
        return items;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    /**
     * Метод возвращает коптю массива this.items без null элементов.
     * Не перебираем все 100 элементов, так как поле position по сути и есть размер нового массива
     *
     * @return Arrays.copyOf(itemsWithoutNull, size);
     */
    public ArrayList<Item> findAll() {

        ArrayList<Item> itemsWithoutNull = new ArrayList<Item>();
        for (Item item1 : items) {
            if (item1 != null) {
                itemsWithoutNull.add(item1);
            }
        }
        return itemsWithoutNull;
    }

    /**
     * Метод проверяет в цикле все элементы массива, сравнивая name с аргументом метода String key.
     * Элементы у которых совпадает name копирует в результирующий массив и возвращает его.
     *
     * @param key
     * @return itemsFindByName
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> itemsFindByName = new ArrayList<Item>();
        for (Item n : items) {
            if (n.getName().equals(key)) {
                itemsFindByName.add(n);
            }
        }
        return itemsFindByName;
    }

    /**
     * Метод проверяет в цикле все элементы массива items, сравнивая id  с аргументом String id.
     * Возвращает найденный Item или null если не нашел.
     *
     * @param id
     * @return item
     */
    public ArrayList<Item> findById(String id) {
        ArrayList<Item> item = new ArrayList<Item>();
        for (Item v : items) {
            if (v.getId().equals(id)) {
                item.add(v);
            }
        }
        return item;
    }

    /**
     * Метод редактирует заявку и возвращает true или false.
     *
     * @return result.
     */
    public boolean replace(String id, String newItem) {
        boolean result = false;
        ArrayList<Item> item = findById(id);
        if (item != null) {
            for (Item c : item) {
                c.setName(newItem);
            }
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    /**
     * Метод удаляет заявку по ID
     *
     * @param id
     * @return result
     */
    public boolean delete(String id) {
        String newItem = null;
        boolean result = false;
        ArrayList<Item> item = findById(id);
        if (item != null) {
            for (Item x : item) {
                x.setName(newItem);
            }
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}


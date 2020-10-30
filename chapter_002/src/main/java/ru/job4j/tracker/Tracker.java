package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final List<Item> items = new ArrayList<Item>();


    /**
     * Метод добавления заявки в хранилище
     *
     * @param item новая заявка
     */
    public List<Item> add(Item item) {
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
    public List<Item> findAll() {
        return items;
    }

    /**
     * Метод проверяет в цикле все элементы массива, сравнивая name с аргументом метода String key.
     * Элементы у которых совпадает name копирует в результирующий массив и возвращает его.
     *
     * @param key
     * @return itemsFindByName
     */
    public List<Item> findByName(String key) {
        List<Item> itemsFindByName = new ArrayList<Item>();
        for (Item n : items) {
            if (n.getName().equals(key)) {
                itemsFindByName.add(n);
            }
        }
        return itemsFindByName;
    }

    /**
     * Метод ищет индекс заявки по id
     *
     * @return index
     */
    public int findIndex(String id) {
        int index = 0;
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (id == item.getId()) {
                index = i;
            }
        }
        return index;
    }

    /**
     * Метод проверяет в цикле все элементы массива items, сравнивая id  с аргументом String id.
     * Возвращает найденный Item или null если не нашел.
     *
     * @param id
     * @return item
     */
    public Item findById(String id) {
        Item item = null;
        item = items.get(findIndex(id));
        return item;
    }


    /**
     * Метод редактирует заявку и возвращает true или false.
     *
     * @return result.
     */
    public boolean replace(String id, String newItem) {
        boolean result = false;
        Item item = findById(id);
        Item a = new Item(newItem);
        a.setId(generateId());
        if (item != null) {
            items.set(findIndex(id), a);
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
        Item item = findById(id);
        if (item != null) {
            items.remove(findIndex(id));
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}



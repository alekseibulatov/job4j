package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод добавления заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
        return item;
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
    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[items.length];
        int size = 0;
        for (int index = 0; index < position; index++) {
            Item item1 = items[index];
            if (item1 != null) {
                itemsWithoutNull[size] = item1;
                size++;
            }
        }
        return Arrays.copyOf(itemsWithoutNull, size);
    }

    /**
     * Метод проверяет в цикле все элементы массива, сравнивая name с аргументом метода String key.
     * Элементы у которых совпадает name копирует в результирующий массив и возвращает его.
     *
     * @param key
     * @return itemsFindByName
     */
    public Item[] findByName(String key) {
        Item[] itemsFindByName = new Item[items.length];
        int size = 0;
        for (int index = 0; index < position; index++) {
            Item item1 = items[index];
            if (key.equals(item1.getName())) {
                itemsFindByName[size] = item1;
                size++;
            }
        }
        itemsFindByName = Arrays.copyOf(itemsFindByName, size);

        return itemsFindByName;
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

        for (int i = 0; i < position; i++) {
            Item item1 = items[i];
            if (id.equals(item1.getId())) {
                item = items[i];
                break;
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
        Item item = findById(id);
        if (item != null) {
            item.setName(newItem);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    /**
     * Метод удаляет заявку по ID
     * @param id
     * @return result
     */
    public boolean delete(String id) {
        String newItem = null;
        boolean result = false;
        Item item = findById(id);
        if (item != null) {
            item.setName(newItem);
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}

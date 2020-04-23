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
     * @return itemsWithoutNull
     */
    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item item1 = items[index];
            if (item1 != null) {
                itemsWithoutNull[size] = item1;
                size++;
            }
        }
        itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, size);
        for (int index = 0; index < itemsWithoutNull.length; index++) {
            Item q = itemsWithoutNull[index];
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
    public Item[] findByName(String key) {
        Item[] itemsFindByName = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item item1 = items[index];
            if (item1 != null && key.equals(item1.getName())) {
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
        Item item = items[0];

        for (int i = 0; i < items.length; i++) {
            Item item1 = items[i];
            if (item1 != null && id.equals(item1.getId())) {
                item = items[i];
                break;
            } else {
                item = null;
            }
        }
        return item;
    }
}

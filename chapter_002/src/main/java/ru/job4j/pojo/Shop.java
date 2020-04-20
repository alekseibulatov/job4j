package ru.job4j.pojo;

public class Shop {
    public static void main(String[] args) {
        Product products[] = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);


        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
        System.out.println();
        System.out.println("Удаляем значение из ячейки с индексом1");
        products[1] = null;

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

        System.out.println();
        System.out.println("Записываем в ячейку с индексом 1 значение ячейки с индексом 2 и удаляем " +
                " значение из ячейки с индексом 2");
        products[1] = products[2];
        products[2] = null;

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];

            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

        System.out.println("Метод delete" + System.lineSeparator());

        delete(products, 1);

    }

    public static Product[] delete(Product[] products, int index) {

        products[index] = null;
        for (int i = 0; i < products.length - 1; i++) {

            if (i < index) { //
                Product product = products[i];
                if (product != null) {
                    System.out.println(product.getName());
                } else {
                    System.out.println("null");
                }
            } else if (i >= index) {
                products[i] = products[i + 1];
                Product product = products[i];
                if (product != null) {
                    System.out.println(product.getName());
                } else {
                    System.out.println("null");
                }
            }
        }
        products[products.length - 1] = null;
        System.out.println(products[products.length - 1]);
        return products;
    }
}





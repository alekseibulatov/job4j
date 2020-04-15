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

        Product eat[] = new Product[6];
        eat[0] = new Product("Meat",2);
        eat[1] = new Product("Bread",1);
        eat[2] = new Product("Apple",5);
        eat[3] = new Product("Water",6);
        eat[4] = new Product("Cheese",1);
        eat[5] = new Product("Tomato",4);


        delete(eat);

    }

    public static Product[] delete(Product[] eat) {

        for (int i = 0; i < eat.length - 1; i++) {
            Product product = eat[i + 1];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
        eat[eat.length-1] = null;
        System.out.println(eat[eat.length-1]);
        return eat;
    }
}





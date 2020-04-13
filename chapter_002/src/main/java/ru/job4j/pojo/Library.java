package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book jackLondon = new Book("Jack London", 100);
        Book cleanCode = new Book("Clean Code", 123);
        Book tolstoy = new Book("Lev  Tolstoy", 500);
        Book king = new Book("Stephen King", 400);

        Book[] bk = new Book[4];
        bk[0] = jackLondon;
        bk[1] = cleanCode;
        bk[2] = tolstoy;
        bk[3] = king;

        for (int index = 0; index < bk.length; index++) {
            Book name = bk[index];
            System.out.println(name.getName() + " - " + name.getPageCount() + System.lineSeparator());
        }

        System.out.println("Replace book 0 and 3" + System.lineSeparator());
        Book temp = bk[0];
        bk[0] = bk[3];
        bk[3] = temp;
        for (int index = 0; index < bk.length; index++) {
            Book name = bk[index];
            System.out.println(name.getName() + " - " + name.getPageCount() + System.lineSeparator());
        }

        System.out.println("Search book Clean Code " + System.lineSeparator());
        for (int index = 0; index < bk.length; index++) {
            Book name = bk[index];
            if (name.equals(bk[1]))
                System.out.println(name.getName() + " - " + name.getPageCount());
        }
    }
}

package ru.job4j.loop;

public class Board {
    public static void paint(int wight, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < wight; j++) {
                if ((i + j) % 2 == 0) {
                    // печатаем X - wight раз.
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            // добавляем перевод нановую строку
            System.out.println();
        }
        }
        public static void main (String[]args){
            paint(3, 3);
            System.out.println();
            paint(5, 4);
        }
    }

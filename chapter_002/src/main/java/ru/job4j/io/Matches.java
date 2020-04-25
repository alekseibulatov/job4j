package ru.job4j.io;



import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 11;
        System.out.println("Игра 11 спичек.");
        System.out.println("Играют 2 игрока.");
        System.out.println("Необходимо взять  от 1 до 3 х спичек. Выигрывает тот кто заберет последнии.");
        while (count > 0) {
            System.out.println("Возьмите спички ");
            int select = Integer.valueOf(input.nextLine());
            if (select > 3) {
                System.out.println("Не верно понято условие. Ввведите число от 1 до 3. Начните игру заново.");
                break;
            }
            count = count - select;
            if (count > 0) {
                System.out.println("Осталось " + count + " спичек");
            } else {
                System.out.println("Вы не можете взять " + select + " спичек. Их осталось " + (count + select) + " шт.");
                System.out.println();
            }
        }
    }
}


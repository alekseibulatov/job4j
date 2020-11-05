package ru.job4j.peerreview;


import java.util.*;

/**
 * Code Review
 *  1. Нет java doc
 *  2. имя пакета не по конвекшену, возможно совпадение имен класса.
 *  3. Убрать пустой конструктор
 *  4. В методе makeList второй цикл for  без {}
 *  5. В методе makeArray   убрать пустые строки в теле
 *  6. В методе makeArray   if  и else без {}
 *
 *
 *
 */

public class Convert {

    public Convert(){

    }

    //Converts array to list
    List<Integer> makeList(int[][] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)
                list.add(array[i][j]);
        }
        return list;
    }


    //Converts list to array
    public int[][] makeArray(List<Integer> list, int rws) {
        Iterator<Integer> iterator = list.iterator();
        int cls = list.size() / rws + (list.size() % rws == 0 ? 0 : 1);


        int[][] array = new int[rws][cls];
        for (int i = 0; i < rws; i++) {
            for (int j = 0; j < cls; j++) {
                if (iterator.hasNext())
                    array[i][j] = iterator.next();
                else
                    array[i][j] = 0;
            }
        }
        return array;
    }
}
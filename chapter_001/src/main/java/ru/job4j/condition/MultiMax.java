package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third){
        int result;
        boolean great1 = first >= second;
        result = great1 ? first : second;
        boolean great2 = result >= third;
         result = great2 ? result : third;
        return result;

    }
}

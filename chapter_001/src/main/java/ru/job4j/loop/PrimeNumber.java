package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int number){
        int count = 0;
        for (int i = 2; i <= number; i++ ){
            if (CheckPrimerNumber.check(i)){
                count++;
            }
        }
        return count;
    }
}

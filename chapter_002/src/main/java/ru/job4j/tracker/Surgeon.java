package ru.job4j.tracker;

public class Surgeon extends Doctor {
    String experience;

    public Surgeon(String name, String surname, String education, String birthday, String nameHospital, String experience) {
        super(name, surname, education, birthday, nameHospital);
        this.experience = experience;
    }

    public void operations() {

    }
}

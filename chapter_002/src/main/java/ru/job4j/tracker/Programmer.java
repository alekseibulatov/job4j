package ru.job4j.tracker;

public class Programmer extends Engineer {
    String nameLanguage;

    public Programmer(String name, String surname, String education, String birthday, String nameCompany, String nameLanguage) {
        super(name, surname, education, birthday, nameCompany);
        this.nameLanguage = nameLanguage;
    }

    public void writeCode() {

    }
}

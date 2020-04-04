package ru.job4j.tracker;

public class Engineer extends Profession {
    String nameCompany;

    public Engineer(String name, String surname, String education, String birthday, String nameCompany) {
        super(name, surname, education, birthday);
        this.nameCompany = nameCompany;
    }

    public void doProjects() {

    }
}

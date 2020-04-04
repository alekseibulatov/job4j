package ru.job4j.tracker;

public class Builder extends Engineer {
    String nameSystem;

    public Builder(String name, String surname, String education, String birthday, String nameCompany, String nameSystem) {
        super(name, surname, education, birthday, nameCompany);
        this.nameSystem = nameSystem;
    }

    public void doProject() {

    }
}

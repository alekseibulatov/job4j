package ru.job4j.tracker;

public class Doctor extends Profession {
    String nameHospital;

    public Doctor(String name, String surname, String education, String birthday, String nameHospital) {
        super(name, surname, education, birthday);
        this.nameHospital = nameHospital;
    }

    public void diagnose() {
    }

    public void medicate() {

    }
}

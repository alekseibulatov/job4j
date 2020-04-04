package ru.job4j.tracker;

public class Dentist extends Doctor {
    int countPatient;

    public Dentist(String name, String surname, String education, String birthday, String nameHospital, int countPatient) {
        super(name, surname, education, birthday, nameHospital);
        this.countPatient = countPatient;
    }

    public void toothCleaning() {

    }
}

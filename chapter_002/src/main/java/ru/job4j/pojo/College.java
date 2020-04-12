package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Bulatov A.A.");
        student.setGroupNumber("282/y");
        student.setDate("13.04.2020");

        System.out.println(student.getFullName() + " in group number " + student.getGroupNumber() +
                " date of receipt " + student.getDate());
    }
}

package ru.job4j.oop;

public class Cat {
    private String food;
    public void show() {
        System.out.println(this.food);
    }

    public String sound() {
        String voice = "may-may";
        return voice;
    }
    public static void main(String[] args) {
        Cat peppy = new Cat();
        String say = peppy.sound();
        System.out.println("Peppy says " + say);
        Cat sparky = new Cat();
        
    }
}


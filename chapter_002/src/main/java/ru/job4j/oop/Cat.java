package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public void show() {
     System.out.println(this.name);
     System.out.println(this.food);
    }
    public void eat(String meat) {
        this.food = meat;
    }
    public void giveNick(String nick) {
        this.name = nick;
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
        Cat gav = new Cat();
        gav.giveNick("gav");
        System.out.println("The first cat's name and his  food.");
        gav.eat("kotleta");
        gav.show();
        Cat black = new Cat();
        black.giveNick("black");
        System.out.println("The second cat's name and his  food.");
        black.eat("fish");
        black.show();
    }
}


package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf1 wolf1 = new Wolf1();
        Fox fox = new Fox();

        hare.tryEat(ball);
        wolf1.tryEat(ball);
        fox.tryEat(ball);
        ball.eat(fox);
    }
}

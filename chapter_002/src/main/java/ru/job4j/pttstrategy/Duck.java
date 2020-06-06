package ru.job4j.pttstrategy;

public class Duck {
    FlyBehavior flyBehavior;
    //QuackBehavior quackBehavior;

    public Duck() {
    }

   // public abstract void display();

    public void performFly() {
        flyBehavior.fly();

    }

  /*  public void performQuack() {

    }
*/
    public void swim() {
        System.out.println("All duck float, even decoys!'");
    }
}

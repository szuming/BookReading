package DesignPattern.BehaviorPattern.StrategyPattern.QuackBehavior;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack!");
    }
}

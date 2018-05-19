package DesignPattern.BehaviorPattern.StrategyPattern.QuackBehavior;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("无法发声!");
    }
}

package DesignPattern.BehaviorPattern.StrategyPattern.FlyBehavior;

public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("火箭飞行！");
    }
}

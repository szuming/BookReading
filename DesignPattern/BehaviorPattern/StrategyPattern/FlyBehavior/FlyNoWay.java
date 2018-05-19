package DesignPattern.BehaviorPattern.StrategyPattern.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("无法飞行！");
    }
}

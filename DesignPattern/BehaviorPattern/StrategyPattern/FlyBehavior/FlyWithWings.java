package DesignPattern.BehaviorPattern.StrategyPattern.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("使用翅膀飞行！");
    }
}

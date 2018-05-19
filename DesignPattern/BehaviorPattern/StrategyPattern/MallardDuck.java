package DesignPattern.BehaviorPattern.StrategyPattern;


import DesignPattern.BehaviorPattern.StrategyPattern.FlyBehavior.FlyWithWings;
import DesignPattern.BehaviorPattern.StrategyPattern.QuackBehavior.Quack;

public class MallardDuck extends Duck {         //绿头鸭,可说话，可飞
    public MallardDuck(){
        quackBehavior=new Quack();              //quackBehavior实例化为Quack(),则可正常说话
        flyBehavior=new FlyWithWings();         //FlyBehavior实例化为FlyWithWings(),则可飞行
    }
    @Override
    public void display() {
        System.out.println("我是模型鸭");
    }
}

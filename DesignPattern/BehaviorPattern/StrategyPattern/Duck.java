package DesignPattern.BehaviorPattern.StrategyPattern;


import DesignPattern.BehaviorPattern.StrategyPattern.FlyBehavior.FlyBehavior;
import DesignPattern.BehaviorPattern.StrategyPattern.QuackBehavior.QuackBehavior;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("我们鸭子都是会游泳的！");
    }

    //以下两个set方法设定了鸭子的行为，则可动态设定鸭子的行为
    public void setFlyBehavior(FlyBehavior fb){
        this.flyBehavior=fb;
    }

    public void setQuackBehavior(QuackBehavior qb){
        this.quackBehavior=qb;
    }
}

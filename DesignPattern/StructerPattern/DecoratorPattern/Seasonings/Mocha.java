package DesignPattern.StructerPattern.DecoratorPattern.Seasonings;


import DesignPattern.StructerPattern.DecoratorPattern.Drinks.Beverage;

/**
 * 具体装饰者,继承了装饰者基类的getDescription()方法，同时也继承了饮料基类的cost()方法
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;                      //被装饰者

    public Mocha(Beverage beverage) {       //将被装饰者传入装饰者类中，实现装饰者记录被装饰者
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+",Mocha";      //将所有组成成分描述出来
    }

    @Override
    public double cost() {
        return .20+beverage.cost();
    }
}

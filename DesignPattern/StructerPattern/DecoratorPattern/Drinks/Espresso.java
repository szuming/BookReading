package DesignPattern.StructerPattern.DecoratorPattern.Drinks;

/**
 * 继承基类饮料类
 */
public class Espresso extends Beverage {
    public Espresso() {
        description="Espresso!";
    }

    @Override
    public double cost() {
        return 2;
    }
}

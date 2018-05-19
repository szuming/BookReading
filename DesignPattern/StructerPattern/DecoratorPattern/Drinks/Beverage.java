package DesignPattern.StructerPattern.DecoratorPattern.Drinks;

public abstract class Beverage {
    String description="Unknown Beverage";
    public String getDescription(){
        return description;
    }

    public abstract double cost();
}

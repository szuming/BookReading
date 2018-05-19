package DesignPattern.CreatedPattern.FactoryPattern.AbstractFactoryPattern;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public String createDough() {
        return "NYDough";
    }

    @Override
    public String createSauce() {
        return "NYSauce";
    }

    @Override
    public String createClam() {
        return "Clam";
    }
}

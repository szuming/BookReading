package DesignPattern.CreatedPattern.FactoryPattern.FactoryMethodPattern;

public class NYStylePizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        Pizza pizza=null;
        if(type.equals("cheese")){
            pizza=new NYStyleCheesePizza();
        }else if(type.equals("clam")){
            pizza=new NYStyleClamPizza();
        }
        return pizza;
    }
}

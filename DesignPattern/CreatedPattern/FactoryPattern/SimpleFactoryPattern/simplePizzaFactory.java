package DesignPattern.CreatedPattern.FactoryPattern.SimpleFactoryPattern;

public class simplePizzaFactory {
    /**
     * 创建Pizza
     * @param type Pizza的类型
     * @return  新建的Pizza
     */
    public Pizza createPizza(String type){
        Pizza pizza=null;
        if(type.equals("cheese"))pizza=new CheesePizza();
        else if(type.equals("clam"))pizza=new ClamPizza();
        return pizza;
    }
}

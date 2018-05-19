package DesignPattern.CreatedPattern.FactoryPattern.FactoryMethodPattern;

public class test {
    public static void main(String argv[]){
        PizzaStore pizzaStore=new NYStylePizzaStore();      //获取一个工厂实例
        pizzaStore.orderPizza("cheese");              //调用其orderPizza来获取pizza
    }
}

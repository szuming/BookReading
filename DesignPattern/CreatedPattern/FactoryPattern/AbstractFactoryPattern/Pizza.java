package DesignPattern.CreatedPattern.FactoryPattern.AbstractFactoryPattern;

public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    String clam;

    abstract void prepare();        //用于准备pizza的材料

    void bake(){System.out.println("Bake for 25 minutes at 350");}

    void cut(){System.out.println("Cutting the pizza into diagonal slices");}

    public void setName(String name){this.name=name;}

    public String getName() {
        return name;
    }
}

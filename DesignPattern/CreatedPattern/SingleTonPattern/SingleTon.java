package DesignPattern.CreatedPattern.SingleTonPattern;

public class SingleTon {
    private volatile static SingleTon uniqueInstance;    //利用一个静态私有变量来记录唯一实例
                                                         //vloatile确保uniqueInstance的值一经改变其他线程会立刻发现

    //这里其他游泳实例化变量

    private SingleTon(){}                       //私有构造器，只有SingleTon类内才可以使用


    public static  SingleTon getInstance(){                          //getInstance()方法实例化对象并获取该对象，
        if(uniqueInstance==null){
            synchronized(SingleTon.class){
                uniqueInstance=new SingleTon();
            }
        }
        return uniqueInstance;
    }

    //这里是其他方法
}

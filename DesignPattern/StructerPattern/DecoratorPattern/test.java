package DesignPattern.StructerPattern.DecoratorPattern;


import DesignPattern.StructerPattern.DecoratorPattern.Drinks.Beverage;
import DesignPattern.StructerPattern.DecoratorPattern.Drinks.Espresso;
import DesignPattern.StructerPattern.DecoratorPattern.IO.LowerCaseInputSteam;
import DesignPattern.StructerPattern.DecoratorPattern.Seasonings.Mocha;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class test {
    public static void main(String []argv){
        Beverage beverage=new Espresso();           //订一杯Espresso
        System.out.println(beverage.getDescription()+"$"+beverage.cost());

        Beverage beverage1=new Espresso();          //再订一杯Espresso，并且加上两份mocha调料
        beverage1=new Mocha(beverage1);
        beverage1=new Mocha(beverage1);
        System.out.println(beverage1.getDescription()+"$"+beverage1.cost());

        //测试装饰的IO类
        try{
            int c;
            InputStream in=new LowerCaseInputSteam(new BufferedInputStream(new FileInputStream("README.md")));
            while((c=in.read())>=0){
                System.out.println((char)c);
            }
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

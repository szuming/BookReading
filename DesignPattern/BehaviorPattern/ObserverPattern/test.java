package DesignPattern.BehaviorPattern.ObserverPattern;


import DesignPattern.BehaviorPattern.ObserverPattern.Observer.CurrentConditionsDisplay;
import DesignPattern.BehaviorPattern.ObserverPattern.Subject.WeatherData;

public class test {
    public static void main(String argv[]){
        //自己实现
        WeatherData weatherData=new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay=new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasureMentrs(80,65,30.4f);
        weatherData.setMeasureMentrs(82,70,29.2f);

        //Java自带

        DesignPattern.BehaviorPattern.ObserverPattern.Javas.Subject.WeatherData temp=new DesignPattern.BehaviorPattern.ObserverPattern.Javas.Subject.WeatherData();
        DesignPattern.BehaviorPattern.ObserverPattern.Javas.Observer.CurrentConditionsDisplay temp1=new DesignPattern.BehaviorPattern.ObserverPattern.Javas.Observer.CurrentConditionsDisplay(temp);
        temp.setMeasureMentrs(80,65,30.4f);
        temp.setMeasureMentrs(82,70,29.2f);
    }
}

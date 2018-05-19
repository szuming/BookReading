package DesignPattern.BehaviorPattern.ObserverPattern.Observer;


import DesignPattern.BehaviorPattern.ObserverPattern.Subject.Subject;

public class CurrentConditionsDisplay implements Observer,DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;            //用于取消订阅

    public CurrentConditionsDisplay(Subject weatherData) {      //注入主题WeatherData
        this.weatherData=weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("current tempature："+temperature+"F degrees and "+humidity+"% humidity");
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature=temperature;
        this.humidity=humidity;
        display();
    }
}

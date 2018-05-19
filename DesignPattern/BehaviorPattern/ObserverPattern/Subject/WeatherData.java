package DesignPattern.BehaviorPattern.ObserverPattern.Subject;


import DesignPattern.BehaviorPattern.ObserverPattern.Observer.Observer;

import java.util.ArrayList;

public class WeatherData implements Subject {
    private ArrayList<Observer> observers;        //记录观察者
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers=new ArrayList();      //初始化观察者链表
    }

    //登记观察者
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    //删除观察者
    @Override
    public void removeObserver(Observer o) {
        int i=observers.indexOf(o);
        if(i>=0){
            observers.remove(i);
        }
    }

    //提醒观察者
    @Override
    public void notifyObservers() {
        for(Observer o:observers){
            o.update(temperature,humidity,pressure);
        }
    }

    //当从气象站得到更新的观测值时，通知观察者
    public void measurementsChanged(){
        notifyObservers();
    }

    //更新观测值
    public void setMeasureMentrs(float temperature,float humidity,float pressure){
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        measurementsChanged();
    }

}

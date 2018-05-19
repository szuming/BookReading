package DesignPattern.BehaviorPattern.ObserverPattern.Javas.Subject;

import java.util.Observable;

public class WeatherData extends Observable {
    //观察者链表与观察者管理都交给了Observable管理
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
    }

    public void measurementsChanged(){
        setChanged();           //设置flag为true，标志可更新数据
        notifyObservers();      //当notifyObservers()没有参数时，说明使用“pull”方法,观察者会从WeahterData中调用getter来获取想要的数据
    }

    //更新观测值
    public void setMeasureMentrs(float temperature,float humidity,float pressure){
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}

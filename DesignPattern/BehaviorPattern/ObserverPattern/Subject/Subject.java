package DesignPattern.BehaviorPattern.ObserverPattern.Subject;


import DesignPattern.BehaviorPattern.ObserverPattern.Observer.Observer;

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}

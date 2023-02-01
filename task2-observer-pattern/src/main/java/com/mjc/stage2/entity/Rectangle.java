package com.mjc.stage2.entity;

import com.mjc.stage2.Observable;
import com.mjc.stage2.Observer;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.impl.RectangleObserver;

import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Observable {
    private int id;
    private double sideA;
    private double sideB;
    private List<Observer> observers;

    // Write your code here!
    public Rectangle(int id, double sideA, double sideB) {
        this.id = id;
        this.sideA = sideA;
        this.sideB = sideB;
        observers = new ArrayList<>();
        observers.add(new RectangleObserver());
        notifyObserver();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
        notifyObserver();
        // Write your code here!
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
        notifyObserver();
        // Write your code here!
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        RectangleEvent rectangleEvent = new RectangleEvent(this);
        for (Observer observer : observers) {
            observer.handleEvent(rectangleEvent);
        }
    }
// Write your code here!
}

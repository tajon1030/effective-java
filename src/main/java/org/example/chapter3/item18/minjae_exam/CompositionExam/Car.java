package org.example.chapter3.item18.minjae_exam.CompositionExam;


public class Car {
    private CarEngine carEngine;

    public Car(CarEngine carEngine) {
        this.carEngine = new CarEngine();
    }

    public void startEngine() {
        carEngine.startEngine();
    }

    public void stopEngine() {
        carEngine.stopEngine();
    }


}

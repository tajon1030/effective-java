package org.example.chapter3.item18.minjae_exam.CompositionExam;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(new CarEngine());
        car.startEngine();
        car.stopEngine();
    }
}

package org.example.chapter3.item18.minjae_exam.CompositionExam;

public class CarEngine {
    public void startEngine(){
        System.out.println("Starting car engine...");
    }

    public void stopEngine(){
        System.out.println("Stopping car engine...");
    }



    // CarEngine 클래스에서만 사용하는 메서드
    public void checkEngine() {
        System.out.println("Checking car engine...");
    }
}
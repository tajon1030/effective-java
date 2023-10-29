package org.example.chapter1.item2;

public class NutritionFactsV3 {

    private int servingSize = -1; // 1회 제공량 (필수)
    private int servings = -1;	// 총 n회 제공량 (필수)
    private int calories = 0;	// 1회 제공량당 칼로리 (선택)
    private int fat = 0;	// 1회 제공량당 지방 (선택)
    private int sodium = 0;	// 1회 제공량당 나트륨 (선택)

    public NutritionFactsV3(){}

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }
}

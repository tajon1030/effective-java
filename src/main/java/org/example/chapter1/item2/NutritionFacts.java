package org.example.chapter1.item2;

public class NutritionFacts {

    private final int servingSize; // 1회 제공량 (필수)
    private final int servings;	// 총 n회 제공량 (필수)

    private final int calories;	// 1회 제공량당 칼로리 (선택)
    private final int fat;	// 1회 제공량당 지방 (선택)
    private final int sodium;	// 1회 제공량당 나트륨 (선택)

    public NutritionFacts(int servingSize, int servings) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = 0;
        this.fat = 0;
        this.sodium = 0;
    }

    public NutritionFacts(int servingSize, int servings, int calories) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = 0;
        this.sodium = 0;
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = 0;
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
    }

}

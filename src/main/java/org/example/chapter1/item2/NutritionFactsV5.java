package org.example.chapter1.item2;

import lombok.Builder;

@Builder(builderMethodName = "innerBuilder")
//@Builder
public class NutritionFactsV5 {


    @Builder.Default
    private int servingSize = -1; // 1회 제공량 (필수)

    @Builder.Default
    private int servings = -1;    // 총 n회 제공량 (필수)

    @Builder.Default
    private int calories = 0;    // 1회 제공량당 칼로리 (선택)

    @Builder.Default
    private int fat = 0;    // 1회 제공량당 지방 (선택)

    @Builder.Default
    private int sodium = 0;    // 1회 제공량당 나트륨 (선택)

    public static NutritionFactsV5Builder builder(int servingSize, int servings) {
        return new NutritionFactsV5Builder()
                .servingSize(servingSize)
                .servings(servings);
    }

    public static void main(String[] args) {

//        NutritionFactsV5 build = NutritionFactsV5.builder()
//                .servingSize(300)
//                .servings(2)
//                .build();

        NutritionFactsV5 nutritionFactsV5 = NutritionFactsV5.builder(300, 2)
                .calories(200)
                .build();
    }
}



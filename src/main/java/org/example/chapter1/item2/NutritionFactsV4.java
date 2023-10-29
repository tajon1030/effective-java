package org.example.chapter1.item2;

public class NutritionFactsV4 {

    private int servingSize = -1;   // 1회 제공량 (필수)
    private int servings = -1;      // 총 n회 제공량 (필수)
    private int calories = 0;       // 1회 제공량당 칼로리 (선택)
    private int fat = 0;            // 1회 제공량당 지방 (선택)
    private int sodium = 0;         // 1회 제공량당 나트륨 (선택)

    public static class Builder {
        private final int servingSize; // 1회 제공량 (필수)
        private final int servings;    // 총 n회 제공량 (필수)

        private int calories = 0;   // 1회 제공량당 칼로리 (선택)
        private int fat = 0;        // 1회 제공량당 지방 (선택)
        private int sodium = 0;     // 1회 제공량당 나트륨 (선택)

        public Builder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val){
            calories = val;
            return this;
        }

        public Builder fat(int val){
            fat = val;
            return this;
        }

        public Builder sodium(int val){
            sodium = val;
            return this;
        }

        public NutritionFactsV4 build(){
            return new NutritionFactsV4(this);
        }
    }

    private NutritionFactsV4(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
    }


    public static void main(String[] args){
        NutritionFactsV4 nutritionFactsV4 = new Builder(100, 3)
                .calories(300)
                .build();
    }
}

package org.example.chapter1.item2;

public class NyPizza extends Pizza {
    public enum Size {SMALL, LARGE}

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = size;
        }

        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    public NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(Size.LARGE)
                .addTopping(Topping.HAM)
                .build();
    }

}

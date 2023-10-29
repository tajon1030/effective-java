package org.example.chapter1.item2;

import java.util.EnumSet;
import java.util.Set;

public abstract class Pizza {

    public enum Topping {HAM, ONION, PEPPER}
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>>{
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping){
            toppings.add(topping);
            return self();
        }

        abstract Pizza build();

        // 하위 클래스는 해당 메서드를 재정의하여 this를 반환하도록 해야함
        protected abstract T self();
    }

    Pizza(Builder<?> builder){
        toppings = builder.toppings.clone();
    }
}

package org.example.chapter2.Item17;

import java.util.List;

public class ParentClass extends UnStableImmutableClass {

    public ParentClass(String name) {
        super(name);
    }

    @Override
    public List<Integer> getList() {
        return super.getList();
    }
}
